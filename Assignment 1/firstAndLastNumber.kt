
fun processInputNumber(): Int {
    print("Please input a number: ")
    val inputString = readLine()!!
    if (inputString.length <= 2) {
        return inputString.toInt()
    }
    var inputNumber = inputString.toInt()

    val lastNumber = inputNumber % 10
    var firstNumber = 0

    while (inputNumber > 0) {
        firstNumber = inputNumber % 10
        inputNumber /= 10
    }

    return  firstNumber * 10 + lastNumber;
}
