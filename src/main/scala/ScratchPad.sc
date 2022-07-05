val a=Array(1,2,3)
val b=Array(1,3,2)

a.sorted.sameElements(b.sorted)


val schemaA=List("node.fname","node.lname", "add.city")
val schemaB=List("node.fname","node.lname", "add.cityname")

val schemaAdash=schemaA.map(a=>((a.split("\\.")(0),a.split("\\.")(1)))).groupBy(_._1).toMap
val schemaBdash=schemaB.map(a=>((a.split("\\.")(0),a.split("\\.")(1)))).groupBy(_._1).toMap

schemaAdash("node")
