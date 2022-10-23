fun weightInPlanets() {
    println("Convert your weight to planet:")

    println("Choice     Planet")
    println("  1        Venus")
    println("  2        Mars")
    println("  3        Jupiter")
    println("  4        Saturn")
    println("  5        Uranus")
    println("  6        Neptune")

    println("Enter your choice: ")
    val planetChoice = readLine()!!.toInt()
    if (!(1 .. 6).contains(planetChoice)) {
        println("You input invalid choice, enter numbers from 1 to 6.")
        weightInPlanets()
    }

    val chosenPlanet = when(planetChoice) {
        1 -> "Venus"
        2 -> "Mars"
        3 -> "Jupiter"
        4 -> "Saturn"
        5 -> "Uranus"
        6 -> "Neptune"
        else -> ""
    }

    println("You chose $chosenPlanet")

    println("Please enter the weight to convert")

    val weight = readLine()!!.toDouble()

    val convertedWeight = when(planetChoice) {
        1 -> weight * 0.78
        2 -> weight * 0.39
        3 -> weight * 2.65
        4 -> weight * 1.17
        5 -> weight * 1.05
        6 -> weight * 1.23
        else -> 0
    }

    println("Your weight is $convertedWeight in $chosenPlanet")
}