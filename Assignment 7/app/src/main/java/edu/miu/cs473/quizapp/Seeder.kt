package edu.miu.cs473.quizapp

import edu.miu.cs473.quizapp.entity.Answer
import edu.miu.cs473.quizapp.entity.Question
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

fun seedQuestions(dao: QuestionDao) {
    GlobalScope.run {
        var question = Question(1, text = "Which of the following is the built-in database of Android?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(1, "SQLite",true),
            Answer(2, "MySQL", false),
            Answer(3, "Oracle", false),
            Answer(4, "None of the above", false),
        )

        question = Question(2, text = "Which of the following is a dialog class in android?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(5, "AlertDialog", false),
            Answer(6, "DatePicker Dialog", false),
            Answer(7, "ProgressDialog", false),
            Answer(8, "All of the above", true),
        )

        question = Question(3, text = "In which state the activity is, if it is not in focus, but still visible on the screen?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(9, "Stopped state", false),
            Answer(10, "Destroyed state", false),
            Answer(11, "Paused state", true),
            Answer(12, "Running state", false),
        )


        question = Question(4, text = "Which of the following method in android is used to log debug messages?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(13, "Log.r()", false),
            Answer(14, "Log.R()", false),
            Answer(15, "Log.d()", true),
            Answer(16, "Log.D()", false),
        )

        question = Question(5, text = "All layout classes are the subclasses of - ")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(17, "android.view.View", false),
            Answer(18, "android.view.ViewGroup", true),
            Answer(19, "android.widget", false),
            Answer(20, "None of the above", false),
        )


        question = Question(6, text = "Which of the following class in android executes the task asynchronously with your service?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(21, "SyncTask", false),
            Answer(22, "AsyncTask", true),
            Answer(23, "Both of the above", false),
            Answer(24, "None of the above", false),
        )


        question = Question(7, text = "Which of the following layout in android arranges its children into rows and columns?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(25, "TableLayout", true),
            Answer(26, "FrameLayout", false),
            Answer(27, "RelativeLayout", false),
            Answer(28, "None of the above", false),
        )


        question = Question(8, text = "What is the default value of the orientation attribute in LinearLayout?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(29, "Vertical", false),
            Answer(30, "Horizontal", true),
            Answer(31, "There is no default value of orientation attribute in LinearLayout", false),
            Answer(32, "None of the above", false),
        )


        question = Question(9, text = "Which of the layer is the lowest layer of android architecture?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(33, "System Libraries and Android Runtime", false),
            Answer(34, "Applications", false),
            Answer(35, "Applications Framework", false),
            Answer(36, "Linux Kernel", true),
        )


        question = Question(10, text = "Which of the following is the parent class of Activity?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(37, "context", false),
            Answer(38, "object", false),
            Answer(39, "contextThemeWrapper", true),
            Answer(40, "None of the above", false),
        )



        question = Question(11, text = "Which of the following android component displays the part of an activity on screen?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(41, "View", false),
            Answer(42, "Manifest", false),
            Answer(43, "Intent", false),
            Answer(44, "Fragment", true),
        )

        question = Question(12, text = "What is contained in manifest.xml?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(45, "Source code", false),
            Answer(46, "List of strings used in the app", false),
            Answer(47, "Permission that the application requires", true),
            Answer(48, "None of the above", false),
        )

        question = Question(13, text = "Which of the following class in android displays information for a short period of time and disappears after some time?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(49, "toast class", true),
            Answer(50, "log class", false),
            Answer(51, "maketest class", false),
            Answer(52, "None of the above", false),
        )


        question = Question(14, text = "How can we kill an activity in android?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(53, "Using finishActivity(int requestCode)", false),
            Answer(54, "Using finish() method", false),
            Answer(55, "All of above", true),
            Answer(56, "None of above", false),
        )

        question = Question(15, text = "ADB stands for _________")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(57, "Android debug bridge", true),
            Answer(58, "Android destroy bridge", false),
            Answer(59, "Android delete bridge", false),
            Answer(60, "None of above", false),
        )


        question = Question(16, text = "How can we stop the services in android?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(61, "By using the finish() method", false),
            Answer(62, "By using system.exit() method", false),
            Answer(63, "By using the stopSelf() and stopService() method", true),
            Answer(64, "None of the above", false),
        )

        question = Question(17, text = "Which of the following converts Java byte code into Dalvik byte code?\n")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(65, "Dex compiler", true),
            Answer(66, "Dalvik converter", false),
            Answer(67, "Mobile interpretive compiler (MIC)", false),
            Answer(68, "None of the above", false),
        )


        question = Question(18, text = "APK stands for ________")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(69, "Android Page Kit", false),
            Answer(70, "Android Phone Kit", false),
            Answer(71, "Android Package Kit", true),
            Answer(72, "None of the above", false),
        )

        question = Question(19, text = "What is the use of content provider in Android?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(73, "For storing the data in the database", false),
            Answer(74, "For sending the data from an application to another application", true),
            Answer(75, "For sharing the data between applications", false),
            Answer(76, "None of the above", false),
        )


        question = Question(20, text = "Which of the following virtual machine is used by the Android operating system?")
        dao.insert(question)
        dao.insertAnswers(question,
            Answer(77, "JVM", false),
            Answer(78, "Simple virtual machine", false),
            Answer(79, "Dalvik virtual machine", true),
            Answer(80, "None of the above", false),
        )
    }
}