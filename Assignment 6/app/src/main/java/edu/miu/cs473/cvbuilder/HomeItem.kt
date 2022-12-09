package edu.miu.cs473.cvbuilder
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class HomeItem(val title: String, val detail: String): Parcelable {

    companion object {
        val all: Array<HomeItem>
            get() {
                return arrayOf(
                    HomeItem("Career note",
                        "<b>Completed</b> on-campus studies and currently taking distance education courses to complete a Master's Degree in Computer Science (Available for full-time, <b>W-2</b> employment)."),
                    HomeItem("Work Experience",
                        """
                        <b>Languages:</b> Swift, Objective C, Java, JavaScript<br />
                        <b>Frameworks/Frontend:</b> iOS, UIKit, Foundation, CocoaTouch, CoreData, CoreAnimation, AFNetworking, GRDB, Hero, Alamofire, React<br />
                        <b>Frameworks/Web:</b> Spring(Boot, MVC, Security, Hibernate, JDBC)<br />
                        <b>Microservices/Cloud:</b> Docker, Kubernetes<br />
                        <b>Databases:</b>MySQL, Postgres SQL, MongoDB<br />
                        <b>Tools:</b> XCode, Intellij IDEA, Maven, Cocoapods, Fastlane, Github, Gitlab, UML
                    """
                    )
                )
            }
    }
}