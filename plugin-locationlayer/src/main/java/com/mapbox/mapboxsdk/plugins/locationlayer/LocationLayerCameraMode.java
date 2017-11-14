package com.mapbox.mapboxsdk.plugins.locationlayer;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Kristian on 02.11.2017.
 */

public class LocationLayerCameraMode {

    /**
     * Use one of these constants when setting {@link LocationLayerPlugin#setCameraMode(int)}
     */

    @IntDef({})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraMode {
    }

    /**
     * Camera mode default state
     */
    public static final int NONE = 0;

    /**
     * Locks the camera
     */
    public static final int LOCKED = 1;


    /**
     * Locks the camera with bearing/compass direction change
     */
    public static final int LOCKED_BEARING = 2;
}
