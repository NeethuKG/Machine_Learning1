import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object LearnJson {



  def main(args:Array[String]):Unit={
//val objectMapper=new ObjectMapper()

    val sc: SparkSession =SparkSession.builder().appName("MyApp").master("local[*]").getOrCreate()
val con=sc.sparkContext
val jsonread=sc.read.option("multiline", true).json("/Users/dinnujames/Desktop/jsontest.rtf")
val jsonreadtext=con.wholeTextFiles("/Users/dinnujames/Desktop/jsontest.rtf")
    val red=sc.read.csv("/Users/dinnujames/Desktop/jsontest.rtf")
    red.show(10,false)
    jsonread.show(1)
    jsonreadtext.top(10)
    jsonread.printSchema()
    println(jsonreadtext.count())
    val structureSchema = new StructType()
      .add("name",new StructType()
        .add("firstname",StringType)
        .add("middlename",StringType)
        .add("lastname",StringType))
      .add("address",new StructType()
        .add("current",new StructType()
          .add("state",StringType)
          .add("city",StringType))
        .add("previous",new StructType()
          .add("state",StringType)
          .add("city",StringType)))

    val read=sc.read.

    structureSchema.printTreeString()
    def flattenStructSchema(schema: StructType, prefix: String = null) : Array[String] = {
      schema.fields.flatMap(f => {
        val columnName = if (prefix == null) f.name else (prefix + "." + f.name)

        f.dataType match {
          case st: StructType => flattenStructSchema(st, columnName)
          //case _ => Array(col(columnName).as(columnName.replace(".","_")))
          case _ => Array(columnName +"_"+  f.dataType)
        }
      })
    }

    System.out.println("Sample")
   val arr= flattenStructSchema(structureSchema)
    for ( i <- arr)
      {
        println(i)
      }

  }
}
