import java.util.Date
import TwitterMain._
import org.json4s._
import org.json4s.native.JsonMethods._
import org.scalatest.FlatSpec

class UtilSpec extends FlatSpec {

  val json1 = "{\n  \"created_at\": \"Fri Feb 05 18:47:20 +0000 2016\",\n  \"id\": 6.9568012239392e+17,\n  \"id_str\": \"695680122393923584\",\n  \"text\": \"@MailChimp an account I manage was blocked\\n'one or more issues that need to be resolved'\\nWe contacted complaince on Jan 16, no word since.\",\n  \"source\": \"<a href=\\\"http:\\/\\/twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client<\\/a>\",\n  \"truncated\": false,\n  \"in_reply_to_status_id\": 6.9567418797369e+17,\n  \"in_reply_to_status_id_str\": \"695674187973685248\",\n  \"in_reply_to_user_id\": 14377870,\n  \"in_reply_to_user_id_str\": \"14377870\",\n  \"in_reply_to_screen_name\": \"MailChimp\",\n  \"user\": {\n    \"id\": 151517368,\n    \"id_str\": \"151517368\",\n    \"name\": \"Tolu Agunbiade\",\n    \"screen_name\": \"thepseudogeek\",\n    \"location\": null,\n    \"url\": \"http:\\/\\/www.skrife.com\",\n    \"description\": \"Saved by Grace | Known for jumping out of comfort zones without a parachute...or shoes | Giving this startup thing a go with @getskrife at @TheSFactoryCL\",\n    \"protected\": false,\n    \"verified\": false,\n    \"followers_count\": 860,\n    \"friends_count\": 273,\n    \"listed_count\": 22,\n    \"favourites_count\": 903,\n    \"statuses_count\": 2437,\n    \"created_at\": \"Thu Jun 03 15:48:19 +0000 2010\",\n    \"utc_offset\": 3600,\n    \"time_zone\": \"West Central Africa\",\n    \"geo_enabled\": false,\n    \"lang\": \"en\",\n    \"contributors_enabled\": false,\n    \"is_translator\": false,\n    \"profile_background_color\": \"EBEBEB\",\n    \"profile_background_image_url\": \"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme7\\/bg.gif\",\n    \"profile_background_image_url_https\": \"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme7\\/bg.gif\",\n    \"profile_background_tile\": false,\n    \"profile_link_color\": \"990000\",\n    \"profile_sidebar_border_color\": \"DFDFDF\",\n    \"profile_sidebar_fill_color\": \"F3F3F3\",\n    \"profile_text_color\": \"333333\",\n    \"profile_use_background_image\": true,\n    \"profile_image_url\": \"http:\\/\\/pbs.twimg.com\\/profile_images\\/636861953948942336\\/V4vge310_normal.jpg\",\n    \"profile_image_url_https\": \"https:\\/\\/pbs.twimg.com\\/profile_images\\/636861953948942336\\/V4vge310_normal.jpg\",\n    \"profile_banner_url\": \"https:\\/\\/pbs.twimg.com\\/profile_banners\\/151517368\\/1451486822\",\n    \"default_profile\": false,\n    \"default_profile_image\": false,\n    \"following\": null,\n    \"follow_request_sent\": null,\n    \"notifications\": null\n  },\n  \"geo\": null,\n  \"coordinates\": null,\n  \"place\": null,\n  \"contributors\": null,\n  \"is_quote_status\": false,\n  \"retweet_count\": 0,\n  \"favorite_count\": 0,\n  \"entities\": {\n    \"hashtags\": [\n      \n    ],\n    \"urls\": [\n      \n    ],\n    \"user_mentions\": [\n      {\n        \"screen_name\": \"MailChimp\",\n        \"name\": \"MailChimp\",\n        \"id\": 14377870,\n        \"id_str\": \"14377870\",\n        \"indices\": [\n          0,\n          10\n        ]\n      }\n    ],\n    \"symbols\": [\n      \n    ]\n  },\n  \"favorited\": false,\n  \"retweeted\": false,\n  \"filter_level\": \"low\",\n  \"lang\": \"en\",\n  \"timestamp_ms\": \"1454698040947\"\n}"
  val json2 = "{\n  \"created_at\": \"Fri Feb 05 18:46:07 +0000 2016\",\n  \"id\": 6.9567981233838e+17,\n  \"id_str\": \"695679812338376704\",\n  \"text\": \"@Ocramius sendmail amazon mandrill mailchimp... in any order\",\n  \"source\": \"<a href=\\\"http:\\/\\/twitter.com\\/download\\/android\\\" rel=\\\"nofollow\\\">Twitter for Android<\\/a>\",\n  \"truncated\": false,\n  \"in_reply_to_status_id\": 6.9563873712082e+17,\n  \"in_reply_to_status_id_str\": \"695638737120817153\",\n  \"in_reply_to_user_id\": 14288063,\n  \"in_reply_to_user_id_str\": \"14288063\",\n  \"in_reply_to_screen_name\": \"Ocramius\",\n  \"user\": {\n    \"id\": 632850021,\n    \"id_str\": \"632850021\",\n    \"name\": \"Nil Portugu\\u00e9s\",\n    \"screen_name\": \"niluspc\",\n    \"location\": \"Barcelona, Catalunya\",\n    \"url\": \"http:\\/\\/nilportugues.com\",\n    \"description\": \"Computer Science Engineer. Senior Webdev. I write APIs too!  Currently @letgo. Former @atrapalo. Membre ple dret @assemblea. Sky is the limit? Nope.\",\n    \"protected\": false,\n    \"verified\": false,\n    \"followers_count\": 723,\n    \"friends_count\": 1754,\n    \"listed_count\": 114,\n    \"favourites_count\": 2421,\n    \"statuses_count\": 13652,\n    \"created_at\": \"Wed Jul 11 10:07:55 +0000 2012\",\n    \"utc_offset\": 3600,\n    \"time_zone\": \"Madrid\",\n    \"geo_enabled\": true,\n    \"lang\": \"en\",\n    \"contributors_enabled\": false,\n    \"is_translator\": false,\n    \"profile_background_color\": \"F0F0F0\",\n    \"profile_background_image_url\": \"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\n    \"profile_background_image_url_https\": \"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\n    \"profile_background_tile\": false,\n    \"profile_link_color\": \"0084B4\",\n    \"profile_sidebar_border_color\": \"FFFFFF\",\n    \"profile_sidebar_fill_color\": \"DDEEF6\",\n    \"profile_text_color\": \"333333\",\n    \"profile_use_background_image\": false,\n    \"profile_image_url\": \"http:\\/\\/pbs.twimg.com\\/profile_images\\/694137298347266050\\/Ju0FiKWd_normal.jpg\",\n    \"profile_image_url_https\": \"https:\\/\\/pbs.twimg.com\\/profile_images\\/694137298347266050\\/Ju0FiKWd_normal.jpg\",\n    \"profile_banner_url\": \"https:\\/\\/pbs.twimg.com\\/profile_banners\\/632850021\\/1441658130\",\n    \"default_profile\": false,\n    \"default_profile_image\": false,\n    \"following\": null,\n    \"follow_request_sent\": null,\n    \"notifications\": null\n  },\n  \"geo\": null,\n  \"coordinates\": null,\n  \"place\": null,\n  \"contributors\": null,\n  \"is_quote_status\": false,\n  \"retweet_count\": 0,\n  \"favorite_count\": 0,\n  \"entities\": {\n    \"hashtags\": [\n      \n    ],\n    \"urls\": [\n      \n    ],\n    \"user_mentions\": [\n      {\n        \"screen_name\": \"Ocramius\",\n        \"name\": \"YAML YOU!\",\n        \"id\": 14288063,\n        \"id_str\": \"14288063\",\n        \"indices\": [\n          0,\n          9\n        ]\n      }\n    ],\n    \"symbols\": [\n      \n    ]\n  },\n  \"favorited\": false,\n  \"retweeted\": false,\n  \"filter_level\": \"low\",\n  \"lang\": \"en\",\n  \"timestamp_ms\": \"1454697967024\"\n}"
  val json3 = "{\n  \"created_at\": \"Fri Feb 05 18:44:58 +0000 2016\",\n  \"id\": 6.9567952617354e+17,\n  \"id_str\": \"695679526173540356\",\n  \"text\": \"RT @natekontny: Whale hunting vs. scale hunting \\n\\nhttps:\\/\\/t.co\\/xrfIceqeGD\\n\\nGreat history of @Mailchimp too from @benchestnut. (h\\/t @cjgallo)\",\n  \"source\": \"<a href=\\\"http:\\/\\/tapbots.com\\/software\\/tweetbot\\/mac\\\" rel=\\\"nofollow\\\">Tweetbot for Mac<\\/a>\",\n  \"truncated\": false,\n  \"in_reply_to_status_id\": null,\n  \"in_reply_to_status_id_str\": null,\n  \"in_reply_to_user_id\": null,\n  \"in_reply_to_user_id_str\": null,\n  \"in_reply_to_screen_name\": null,\n  \"user\": {\n    \"id\": 12912522,\n    \"id_str\": \"12912522\",\n    \"name\": \"Pascal Lalibert\\u00e9\",\n    \"screen_name\": \"pascallaliberte\",\n    \"location\": \"Ottawa, ON\",\n    \"url\": \"http:\\/\\/pascallaliberte.me\",\n    \"description\": \"E-learning at @uOttawaMed, and the guy behind @PopupLMS. You'll read about making thoughtful decisions, about product development and about Christianity.\",\n    \"protected\": false,\n    \"verified\": false,\n    \"followers_count\": 438,\n    \"friends_count\": 569,\n    \"listed_count\": 71,\n    \"favourites_count\": 401,\n    \"statuses_count\": 3732,\n    \"created_at\": \"Thu Jan 31 17:08:27 +0000 2008\",\n    \"utc_offset\": -18000,\n    \"time_zone\": \"Eastern Time (US & Canada)\",\n    \"geo_enabled\": true,\n    \"lang\": \"fr\",\n    \"contributors_enabled\": false,\n    \"is_translator\": false,\n    \"profile_background_color\": \"5E4F3A\",\n    \"profile_background_image_url\": \"http:\\/\\/pbs.twimg.com\\/profile_background_images\\/9842615\\/stripe_eca81e8bafae7a83a6a7bb6f31347168.png\",\n    \"profile_background_image_url_https\": \"https:\\/\\/pbs.twimg.com\\/profile_background_images\\/9842615\\/stripe_eca81e8bafae7a83a6a7bb6f31347168.png\",\n    \"profile_background_tile\": true,\n    \"profile_link_color\": \"A5591D\",\n    \"profile_sidebar_border_color\": \"CDA770\",\n    \"profile_sidebar_fill_color\": \"DDB478\",\n    \"profile_text_color\": \"5E4F3A\",\n    \"profile_use_background_image\": true,\n    \"profile_image_url\": \"http:\\/\\/pbs.twimg.com\\/profile_images\\/2634766556\\/8dcd3ce545cb0bd2c4e453009f98cbd3_normal.jpeg\",\n    \"profile_image_url_https\": \"https:\\/\\/pbs.twimg.com\\/profile_images\\/2634766556\\/8dcd3ce545cb0bd2c4e453009f98cbd3_normal.jpeg\",\n    \"default_profile\": false,\n    \"default_profile_image\": false,\n    \"following\": null,\n    \"follow_request_sent\": null,\n    \"notifications\": null\n  },\n  \"geo\": null,\n  \"coordinates\": null,\n  \"place\": null,\n  \"contributors\": null,\n  \"retweeted_status\": {\n    \"created_at\": \"Fri Feb 05 17:56:48 +0000 2016\",\n    \"id\": 6.9566740370809e+17,\n    \"id_str\": \"695667403708092416\",\n    \"text\": \"Whale hunting vs. scale hunting \\n\\nhttps:\\/\\/t.co\\/xrfIceqeGD\\n\\nGreat history of @Mailchimp too from @benchestnut. (h\\/t @cjgallo)\",\n    \"source\": \"<a href=\\\"http:\\/\\/twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client<\\/a>\",\n    \"truncated\": false,\n    \"in_reply_to_status_id\": null,\n    \"in_reply_to_status_id_str\": null,\n    \"in_reply_to_user_id\": null,\n    \"in_reply_to_user_id_str\": null,\n    \"in_reply_to_screen_name\": null,\n    \"user\": {\n      \"id\": 17386551,\n      \"id_str\": \"17386551\",\n      \"name\": \"Nathan Kontny\",\n      \"screen_name\": \"natekontny\",\n      \"location\": \"Chicago\",\n      \"url\": \"http:\\/\\/ninjasandrobots.com\",\n      \"description\": \"I like to make stuff on computers. CEO of Highrise (https:\\/\\/highrisehq.com\\/)\",\n      \"protected\": false,\n      \"verified\": false,\n      \"followers_count\": 11318,\n      \"friends_count\": 521,\n      \"listed_count\": 468,\n      \"favourites_count\": 11515,\n      \"statuses_count\": 8571,\n      \"created_at\": \"Fri Nov 14 12:38:24 +0000 2008\",\n      \"utc_offset\": -21600,\n      \"time_zone\": \"Central Time (US & Canada)\",\n      \"geo_enabled\": false,\n      \"lang\": \"en\",\n      \"contributors_enabled\": false,\n      \"is_translator\": false,\n      \"profile_background_color\": \"1A1B1F\",\n      \"profile_background_image_url\": \"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme9\\/bg.gif\",\n      \"profile_background_image_url_https\": \"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme9\\/bg.gif\",\n      \"profile_background_tile\": false,\n      \"profile_link_color\": \"7696BF\",\n      \"profile_sidebar_border_color\": \"FFFFFF\",\n      \"profile_sidebar_fill_color\": \"252429\",\n      \"profile_text_color\": \"666666\",\n      \"profile_use_background_image\": true,\n      \"profile_image_url\": \"http:\\/\\/pbs.twimg.com\\/profile_images\\/1769389798\\/image1327095694_normal.png\",\n      \"profile_image_url_https\": \"https:\\/\\/pbs.twimg.com\\/profile_images\\/1769389798\\/image1327095694_normal.png\",\n      \"default_profile\": false,\n      \"default_profile_image\": false,\n      \"following\": null,\n      \"follow_request_sent\": null,\n      \"notifications\": null\n    },\n    \"geo\": null,\n    \"coordinates\": null,\n    \"place\": null,\n    \"contributors\": null,\n    \"is_quote_status\": false,\n    \"retweet_count\": 2,\n    \"favorite_count\": 2,\n    \"entities\": {\n      \"hashtags\": [\n        \n      ],\n      \"urls\": [\n        {\n          \"url\": \"https:\\/\\/t.co\\/xrfIceqeGD\",\n          \"expanded_url\": \"http:\\/\\/tinyletter.com\\/ben\\/letters\\/whale-hunting-or-scale-hunting\",\n          \"display_url\": \"tinyletter.com\\/ben\\/letters\\/wh\\u2026\",\n          \"indices\": [\n            34,\n            57\n          ]\n        }\n      ],\n      \"user_mentions\": [\n        {\n          \"screen_name\": \"MailChimp\",\n          \"name\": \"MailChimp\",\n          \"id\": 14377870,\n          \"id_str\": \"14377870\",\n          \"indices\": [\n            76,\n            86\n          ]\n        },\n        {\n          \"screen_name\": \"benchestnut\",\n          \"name\": \"Ben Chestnut\",\n          \"id\": 17876157,\n          \"id_str\": \"17876157\",\n          \"indices\": [\n            96,\n            108\n          ]\n        },\n        {\n          \"screen_name\": \"cjgallo\",\n          \"name\": \"Chris Gallo\",\n          \"id\": 25209835,\n          \"id_str\": \"25209835\",\n          \"indices\": [\n            115,\n            123\n          ]\n        }\n      ],\n      \"symbols\": [\n        \n      ]\n    },\n    \"favorited\": false,\n    \"retweeted\": false,\n    \"possibly_sensitive\": false,\n    \"filter_level\": \"low\",\n    \"lang\": \"en\"\n  },\n  \"is_quote_status\": false,\n  \"retweet_count\": 0,\n  \"favorite_count\": 0,\n  \"entities\": {\n    \"hashtags\": [\n      \n    ],\n    \"urls\": [\n      {\n        \"url\": \"https:\\/\\/t.co\\/xrfIceqeGD\",\n        \"expanded_url\": \"http:\\/\\/tinyletter.com\\/ben\\/letters\\/whale-hunting-or-scale-hunting\",\n        \"display_url\": \"tinyletter.com\\/ben\\/letters\\/wh\\u2026\",\n        \"indices\": [\n          50,\n          73\n        ]\n      }\n    ],\n    \"user_mentions\": [\n      {\n        \"screen_name\": \"natekontny\",\n        \"name\": \"Nathan Kontny\",\n        \"id\": 17386551,\n        \"id_str\": \"17386551\",\n        \"indices\": [\n          3,\n          14\n        ]\n      },\n      {\n        \"screen_name\": \"MailChimp\",\n        \"name\": \"MailChimp\",\n        \"id\": 14377870,\n        \"id_str\": \"14377870\",\n        \"indices\": [\n          92,\n          102\n        ]\n      },\n      {\n        \"screen_name\": \"benchestnut\",\n        \"name\": \"Ben Chestnut\",\n        \"id\": 17876157,\n        \"id_str\": \"17876157\",\n        \"indices\": [\n          112,\n          124\n        ]\n      },\n      {\n        \"screen_name\": \"cjgallo\",\n        \"name\": \"Chris Gallo\",\n        \"id\": 25209835,\n        \"id_str\": \"25209835\",\n        \"indices\": [\n          131,\n          139\n        ]\n      }\n    ],\n    \"symbols\": [\n      \n    ]\n  },\n  \"favorited\": false,\n  \"retweeted\": false,\n  \"possibly_sensitive\": false,\n  \"filter_level\": \"low\",\n  \"lang\": \"en\",\n  \"timestamp_ms\": \"1454697898797\"\n}"

  val parsedJson1 = parse(json1)
  val richTweet = extractTweetJSONFields(parsedJson1)
  println("RichTweet Transformed JSON")
  println(richTweet)
  assert(richTweet.text == "@MailChimp an account I manage was blocked\n'one or more issues that need to be resolved'\nWe contacted complaince on Jan 16, no word since.")
  assert(richTweet.createdAt == new Date("Fri Feb 05 13:47:20 EST 2016"))
  assert(richTweet.userName == "Tolu Agunbiade")
  assert(richTweet.userHandle == "thepseudogeek")
  assert(richTweet.userLocation == null)
  assert(richTweet.userFollowerCount == "860")
  println()

  val bytes = serializeTweet[Tweet](richTweet)
  val newRichTweet = deserializeTweet[Tweet](bytes)
  println("RichTweet Deserialized JSON")
  println(newRichTweet)
  assert(richTweet.equals(newRichTweet))
  println("==========================")
  println()

  val parsedJson2 = parse(json2)
  val richTweet2 = extractTweetJSONFields(parsedJson2)
  println("RichTweet2 Transformed JSON")
  println(richTweet2)
  assert(richTweet2.text == "@Ocramius sendmail amazon mandrill mailchimp... in any order")
  assert(richTweet2.createdAt == new Date("Fri Feb 05 13:46:07 EST 2016"))
  assert(richTweet2.userName == "Nil Portugués")
  assert(richTweet2.userHandle == "niluspc")
  assert(richTweet2.userLocation == "Barcelona, Catalunya")
  assert(richTweet2.userFollowerCount == "723")
  println()

  val bytes2 = serializeTweet[Tweet](richTweet2)
  val newRichTweet2 = deserializeTweet[Tweet](bytes2)
  println("RichTweet2 Deserialized JSON")
  println(newRichTweet2)
  assert(richTweet2.equals(newRichTweet2))
  println("==========================")
  println()

  val parsedJson3 = parse(json3)
  val richTweet3 = extractTweetJSONFields(parsedJson3)
  println("RichTweet3 Transformed JSON")
  println(richTweet3)
  assert(richTweet3.text == "RT @natekontny: Whale hunting vs. scale hunting \n\nhttps://t.co/xrfIceqeGD\n\nGreat history of @Mailchimp too from @benchestnut. (h/t @cjgallo)")
  assert(richTweet3.createdAt == new Date("Fri Feb 05 13:44:58 EST 2016"))
  assert(richTweet3.userName == "Pascal Laliberté")
  assert(richTweet3.userHandle == "pascallaliberte")
  assert(richTweet3.userLocation == "Ottawa, ON")
  assert(richTweet3.userFollowerCount == "438")
  println()

  val bytes3 = serializeTweet[Tweet](richTweet3)
  val newRichTweet3 = deserializeTweet[Tweet](bytes3)
  println("RichTweet3 Deserialized JSON")
  println(newRichTweet3)
  assert(richTweet3.equals(newRichTweet3))
  println()

}
