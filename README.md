# Reactive Data Pipelines

Reactive version of the `data-pipelines` [project](//github.com/bradware/data-pipelines).

## Data Pipelines
* [Reactive Simple Actor Pipeline](//github.com/bradware/reactive-data-pipelines/blob/master/src/main/scala/reactive-simple-actor-pipeline/ReactiveSimpleActorPipeline.scala)
* [Reactive Simple Tweet Pipeline](//github.com/bradware/reactive-data-pipelines/blob/master/src/main/scala/reactive-simple-tweet-pipeline/ReactiveSimpleTweetPipeline.scala)
* [Reactive Twitter Pipeline](//github.com/bradware/reactive-data-pipelines/blob/master/src/main/scala/reactive-twitter-pipeline/ReactiveTwitterPipeline.scala)

## Technologies
* [Scala](//www.scala-lang.org/download)
* [Kafka](http://kafka.apache.org/downloads.html) (v9)
* [Reactive Kafka](//github.com/softwaremill/reactive-kafka)
* [Akka Streams](//doc.akka.io/docs/akka-stream-and-http-experimental/2.0.2/scala.html)
* [Twitter HBC API](//github.com/twitter/hbc)
* [Kryo - Twitter Chill](//github.com/twitter/chill)

## Getting Started
* download [Kafka 9](//kafka.apache.org/downloads.html)
* navigate to where you downloaded kafka 9: 
  * `cd kafka_2.11-0.9.0.0`
* `bin/zookeeper-server-start.sh config/zookeeper.properties`
* `bin/kafka-server-start.sh config/server.properties`
* Create raw data Kafka Topic (insert real name for topic_name): 
  * `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic_name`
* Create transformed data Kafka Topic (insert real name for topic_name): 
  * `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic_name`
* See new topics created:
  * `bin/kafka-topics.sh --list --zookeeper localhost:2181`

## Reactive Simple Actor Pipeline
### Overview
* Publish messages to Kafka Topic through command-line Kafka Producer
  *  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic topic_name`
* Read messages using Kakfa Consumer encapsulated by Actor Publisher
* Messages go through stream where they are capitalized and stored as `SimpleMessage`
* Console Sink dumps `SimpleMessage` to console

`KafkaTopic --> ActorPub --> Stream --> ConsoleSink`

**Note**: Make sure the kakfa topic in `ReactiveSimpleActorPipeline.scala` matches the one you created during **Getting Started** and for the command line Kafka Producer

Run through `ReactiveSimpleActorPipeline.scala`

## Reactive Simple Tweet Pipeline
### Overview
* Use the Kafka Producer through the command line to send messages to the lowercase Kafka Topic
  *  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic topic_name`
* ActorPublisher uses Kafka Consumer to read from Topic and push to First Stream
* First Stream capitalizes messages and transforms to `StringProducerMessage`
* ActorSubscriber reads from stream and uses Kafka Producer to push to uppercase Kafka Topic
* ActorPublisher uses Kafka Consumer to read from uppercase Kafka Topic and push to Second Stream
* Second Stream transforms from `StringConsumerRecord` to `SimpleTweet`
* Console Sink reads from Second Stream and dumps output to console

`KafkaTopic --> ActorPub --> FirstStream --> ActorSub --> KafkaTopic --> ActorPub --> SecondStream --> ConsoleSink`

**Note**: Make sure the kakfa topic in `ReactiveSimpleTweetPipeline.scala` matches the one you created during **Getting Started** and for the command line Kafka Producer

Run through `ReactiveSimpleTweetPipeline.scala`

## Reactive Twitter Pipeline
In `Config.scala` update the filter terms list and your auth credentials (see below) to correctly setup your Twitter HBC stream. The current one pulls tweets based on filtering for [MailChimp](//mailchimp.com).

```scala
val terms = List("MailChimp", "Mailchimp", "MailChimp Status", "Mailchimp Status", "MailChimp UX", "Mailchimp UX", "MailChimp Design","Mailchimp Design", "MailChimp API", "Mailchimp API", "Mandrill", "mandrillapp", "TinyLetter", "Tinyletter")
```

```scala
val CONSUMER_KEY = "insert_consumer_key"
val CONSUMER_SECRET = "insert_consumer_secret"
val ACCESS_TOKEN = "insert_access_token"
val SECRET_TOKEN = "insert_secret_token"
```

### Overview
* Pull raw json tweets from Twitter HBC
* Push raw json tweets into Kafka topic through Kafka Producer
* Pull raw json tweets from Kafka Consumer and store in Akka Publisher
* Akka Publisher sends raw json through raw stream to transform/serialize to `Tweet` object
* Akka Subscriber takes serialized `Tweet` object and uses Kafka Producer to push to another Kafka Topic
* Kafka Consumer inside Akka Publisher pulls from topic and sends serialized `Tweet` through transformed stream
* Final Stream deserializes the `Tweet` object
* Sink reads from Final Stream and dumps to console

`TwitterHBC --> KafkaProd --> KafkaTopic --> ActorPub --> RawStream --> ActorSub --> KafkaTopic --> ActorPub -->  TransformedStream --> ConsoleSink`

**Note**: Make sure the kakfa topics (yes Reactive Twitter Pipeline has 2) in `ReactiveTwitterPipeline.scala` match the topics you created during **Getting Started** 

Run through `ReactiveTwitterPipeline.scala`
