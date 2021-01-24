package nms.az.onlineacademy;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by anar on 7/22/15.
 */
public class OnlineAcademyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/myriad_pro.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
