const val SPACE = ' '
const val NEW_LINE = '\n'
const val LINE_LENGTH = 100
const val TEXT = "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

fun main(args: Array<String>) {
    println(TEXT.wrap(LINE_LENGTH))
}

fun String.wrap(lineLength: Int): String {
    val newString = this.toCharArray()
    val spacePositions = mutableListOf(0)
    val newLinePositions = mutableListOf(0)

    for (i in this.indices) {
        if (this[i] == SPACE) {
            if (i > lineLength + newLinePositions.last()) {
                newString[spacePositions.last()] = NEW_LINE
                newLinePositions.add(spacePositions.last())
            }
            spacePositions.add(i)
        }
    }

    return newString.concatToString()
}