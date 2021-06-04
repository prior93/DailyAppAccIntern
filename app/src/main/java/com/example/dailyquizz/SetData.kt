package com.example.dailyquizz

object SetData {

    const val name:String="name"
    const val score:String="score"


    fun getQuestion():ArrayList<QuestionData>{

        var que = ArrayList<QuestionData>()
        var question1 = QuestionData(1,"What is Capital Of Nepal?","Berlin","Lhasa","Hanoi",
        "Kathmandu",4)

        var question2 = QuestionData(
            2,
            "Who was the first  woman in Space ?",

            "Valentina Tereshkova",
            "Sunita Williams",
            "Koneru Humpy",
            "None of the above",
            1
        )
        var question3 = QuestionData(
            3,
            "Number Of States in USA ?",

            "49",
            "50",
            "52",
            "53",
            2
        )
        var question4 = QuestionData(
            4,
            "Who is the  President of Latvia ?",

            "Koen Lenaerts",
            "Andra Levite",
            "Egils Levits",
            "Krisjanis Karins",
            3
        )

        var question5 = QuestionData(
            5,
            "What is capital of switzerland ?",

            "Basel",
            "zurich",
            "Geneva",
            "Bern",
            4
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que

    }//:getQuestion
}