package edu.miu.cs473.cvbuilder

class WorkItem(val title: String,
               val companyName: String,
               val fromToDate: String,
               val location: String,
               val description: String,
               val companyLogo: Int) {

    companion object {
        val all: Array<WorkItem>
        get() {
            return arrayOf(
                WorkItem(
                    "Senior Software Engineer",
                    "Finnair",
                    "May, 2018 - April, 2022",
                    "Helsinki, Finland",
                    "Developing iPhone applications",
                    R.drawable.finnair_logo
                ),
                WorkItem(
                    "Senior Software Engineer",
                    "Dexintel",
                    "May, 2016 - May, 2018",
                    "Helsinki, Finland",
                    "Developed Web applications and mobile apps",
                    R.drawable.dexintel_logo
                ),
                WorkItem(
                    "Software Developer",
                    "Beddit",
                    "Aug, 2014 - May, 2016",
                    "Helsinki, Finland",
                    "Developing iOS applications",
                    R.drawable.beddit_logo
                ),
                WorkItem(
                    "Software Developer",
                    "Introdex Oy",
                    "Jun, 2012 - Jul 2014",
                    "Helsinki, Finland",
                    "Developing introdex iPhone app",
                    R.drawable.introdex_logo
                ),
                WorkItem(
                    "iPhone Developer",
                    "Cloudfactory",
                    "Mar, 2011 - Aug, 2011",
                    "Kathmandu, Nepal",
                    "Intern iOS Developer",
                    R.drawable.cloudfactory_logo
                )
            )
        }
    }
}