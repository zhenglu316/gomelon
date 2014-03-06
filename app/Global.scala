import play.api._

import models._
import anorm._

import com.mongodb.casbah.commons.Imports._
import org.bson.types.ObjectId

object Global extends GlobalSettings {
  
  override def onStart(app: Application) {
    // TODO initial test Data.
    InitialData.insert()
  }
  
}

/**
 * Initial set of data to be imported 
 * in the sample application.
 */
object InitialData {
  
  def date(str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str)
  
  def insert() = {
    
    if(Salon.findAll == Nil) { 
      Seq(
        Salon(new ObjectId("530d7288d7f2861457771bdd"), "火影忍者发型"),
        Salon(new ObjectId("530d7292d7f2861457771bde"), "海贼王发型")
      ).foreach(Salon.save)
      
      Seq(
        Stylist(new ObjectId("530d8010d7f2861457771bf8"), "漩涡鸣人", new ObjectId("530d7288d7f2861457771bdd")),
        Stylist(new ObjectId("530d8010d7f2861457771bf9"), "宇智波佐助", new  ObjectId("530d7288d7f2861457771bdd")),
        Stylist(new ObjectId("530d8010d7f2861457771bfa"), "宇智波带土", new ObjectId("530d7288d7f2861457771bdd")),
        Stylist(new ObjectId("530d8010d7f2861457771bfb"), "宇智波斑", new ObjectId("530d7288d7f2861457771bdd")),
        Stylist(new ObjectId("530d8010d7f2861457771bfc"), "千手柱间", new ObjectId("530d7288d7f2861457771bdd")),

        Stylist(new ObjectId("530d8010d7f2861457771bfd"), "路飞", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771bfe"), "索隆", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771bff"), "香吉士", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771c00"), "娜美", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771c01"), "乔巴", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771c02"), "罗宾", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771c03"), "乌索普", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771c04"), "弗兰奇", new ObjectId("530d7292d7f2861457771bde")),
        Stylist(new ObjectId("530d8010d7f2861457771c05"), "布鲁克", new ObjectId("530d7292d7f2861457771bde"))
      ).foreach(Stylist.save)
      
      Seq(
        Style(new ObjectId("530d828cd7f2861457771c0b"), "四代火影发型式", new ObjectId("530d7288d7f2861457771bdd"), new ObjectId("530d8010d7f2861457771bf8")),
        Style(new ObjectId("530d828cd7f2861457771c0c"), "六道仙人发型", new ObjectId("530d7288d7f2861457771bdd"), new ObjectId("530d8010d7f2861457771bf8")),
        Style(new ObjectId("530d828cd7f2861457771c0d"), "海贼王发型", new ObjectId("530d7288d7f2861457771bde"), new ObjectId("530d8010d7f2861457771bfd"))
      ).foreach(Style.save)

    }

    if(ServiceType.findAll.isEmpty) {
	Seq (
          ServiceType(new  ObjectId("5316798cd4d5cb7e816db34b"), "剪"),
	  ServiceType(new ObjectId("5316798cd4d5cb7e816db34b"), "剪"),
	  ServiceType(new ObjectId("53167a91d4d5cb7e816db34d"), "洗"),
	  ServiceType(new ObjectId("53167abbd4d5cb7e816db34f"), "吹"),
	  ServiceType(new ObjectId("53167aced4d5cb7e816db351"), "染"),
	  ServiceType(new ObjectId("53167ad9d4d5cb7e816db353"), "护理"),
	  ServiceType(new ObjectId("53167ae7d4d5cb7e816db355"), "烫"),
	  ServiceType(new ObjectId("53167b3cd4d5cb7e816db359"), "柔顺"),
	  ServiceType(new ObjectId("5316c443d4d57997ce3e6d68"), "其他")
        ).foreach(ServiceType.save)

	Seq (
	  Service(new ObjectId("53168b38d4d5cb7e816db35c"), "剪刘海", "剪", 10, 10) ,
	  Service(new ObjectId("53168b61d4d5cb7e816db35e"), "数码烫", "烫", 90, 100),
	  Service(new ObjectId("5316bb36d4d57997ce3e6d49"), "离子烫", "烫", 90, 100),
	  Service(new ObjectId("5316bb51d4d57997ce3e6d4b"), "局部染", "染", 90, 120),
	  Service(new ObjectId("5316be49d4d57997ce3e6d50"), "小脸剪", "剪", 20, 30) ,
	  Service(new ObjectId("5316be8ed4d57997ce3e6d52"), "3D彩色", "染", 80, 150),
	  Service(new ObjectId("5316beb4d4d57997ce3e6d54"), "低色短", "染", 80, 140),
	  Service(new ObjectId("5316bed4d4d57997ce3e6d56"), "蒸汽烫", "染", 45, 80) ,
	  Service(new ObjectId("5316bef6d4d57997ce3e6d58"), "纯护理", "护理", 50, 66) ,
	  Service(new ObjectId("5316c048d4d57997ce3e6d5a"), "简洗", "洗", 10, 10) ,
	  Service(new ObjectId("5316c05bd4d57997ce3e6d5c"), "干洗", "洗", 15, 20) ,
	  Service(new ObjectId("5316c07fd4d57997ce3e6d5e"), "简吹", "吹", 10, 15) ,
	  Service(new ObjectId("5316c0a2d4d57997ce3e6d60"), "豪华护理", "护理", 70, 200),
	  Service(new ObjectId("5316c0d1d4d57997ce3e6d62"), "拉直", "柔顺", 30, 50) ,
	  Service(new ObjectId("5316ec2fd4d57997ce3e6d97"), "盘发", "其他", 50, 50) ,
	  Service(new ObjectId("5316ecffd4d57997ce3e6d9d"), "盘发2", "其他", 100, 80) 
	).foreach(Service.save)

    }


  }
  
}
