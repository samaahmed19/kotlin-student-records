fun main() {
    val studentNames: List<String> = listOf("Ahmed", "Laila", "Nour", "Sara", "Khaled", "Yasmine")
    val studentScores: MutableMap<String, Int> = mutableMapOf(
        "Ahmed" to 85,
        "Laila" to 72,
        "Nour" to 95,
        "Sara" to 60,
        "Khaled" to 40,
        "Yasmine" to 88
    )
    val graduatedStudents: Set<String> = setOf("Sara", "Khaled")

    println("Student Names: $studentNames")
    println("Student Scores: $studentScores")
    println("Graduated Students: $graduatedStudents")
    println()

    println("Students who haven't graduated:")
    for (name in studentNames) {
        if (name !in graduatedStudents) {
            println("$name - Score: ${studentScores[name]}")
        }
    }
    println()

    println("Uppercased Student Names:")
    studentNames.map { it.uppercase() }.forEach { println(it) }

    println("Students with score > 80:")
    studentScores
        .filter { it.value > 80 }
        .map { it.key.uppercase() }
        .forEach { println(it) }
    println()

    val totalScore = studentScores.values.reduce { acc, score -> acc + score }
    println("Total Score: $totalScore")

    val formattedString = studentScores.entries.fold("") { acc, entry ->
        if (acc.isEmpty()) "${entry.key}: ${entry.value}"
        else "$acc | ${entry.key}: ${entry.value}"
    }
    println("Formatted Scores: $formattedString")
    println()

    println("Student Grade Report:")
    generateStudentReport(studentScores)
}

fun generateStudentReport(scores: Map<String, Int>) {
    if (scores.isEmpty()) {
        println("No student data available.")
        return
    }

    scores
        .filter { it.value >= 60 }
        .map { "${it.key}: Passed" }
        .forEach { println(it) }
}
