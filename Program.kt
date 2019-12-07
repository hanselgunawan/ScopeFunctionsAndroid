fun main(args: Array<String>){
  val firstPerson = Person("Hansel", 25, "QA")
  val secondPerson = Person("Andy", 22, "Finance Advisor")
  
  val olderPerson = if(firstPerson.age >= secondPerson.age) firstPerson else secondPerson
  olderPerson.printPerson()
  
  // 1. RUN
  run {
    if(firstPerson.age >= secondPerson.age) firstPerson else secondPerson
  }.printPerson()
  
  // 2. WITH
  with(firstPerson) { // firstPerson is called a RECEIVER
    age += 1
    "Age is now $age"
  }.println()
  
  // WITH IS EQUIVALENT TO...
  firstPerson.run { // firstPerson here is a RECEIVER
    age += 1
    "Age is now $age"
  }.println()
  
  // 3. LET
  // Act like RUN but you'll get PARAMETER instead of a RECEIVER
  firstPerson.let { modifiedPerson ->
    modifiedPerson.age += 1
    "Age is now ${modifiedPerson.age}" // this is called Interpolation
  }.println()
  
  // 4. APPLY
  // APPLY can be used if you want to change the value of your contructor
  // E.g change the secondPerson age
  secondPerson.apply {
    age += 1
    job = "Software Engineer"
  }.printPerson()
  
  // 5. ALSO
  // Act like APPLY but you will get PARAMETER so you can rename it instead of a RECEIVER
  secondPerson.also { andy ->
    andy.age += 1
    andy.job = "Content Creator"
  }.printPerson()
  
}

data class Person(var name: String, var age: Int, var job: String) {
  fun printPerson() = println(this.toString())
}

fun String.println() = println(this)
