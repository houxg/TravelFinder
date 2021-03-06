package org.liangxw.travelfinder.model;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVGeoPoint;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;
import com.avos.avoscloud.SignUpCallback;

import org.liangxw.travelfinder.util.logger.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by houxg on 2015/4/11.
 */
public class UserWrapper {

    public final static String TAG = UserWrapper.class.getSimpleName();
    public final static int TYPE_VISITOR = 1;
    public final static int TYPE_GUIDE = 2;
    AVUser avUser;


    public final static String CLASS_NAME = "_User";
    public final static String OBJECT_ID = "objectId";
    public final static String NICK_NAME = "nickName";
    public final static String TYPE = "type";
    public final static String LOCATION_UPDATE_STATE = "locationUpdateState";
    public final static String LOCATION = "location";
    public final static String ACCURACY = "accuracy";
    public final static String LOCATION_UPDATE_TIME = "locationUpdateTime";
    public final static String AVATAR = "avatar";

    public UserWrapper() {
        avUser = new AVUser();
    }

    public static List<UserWrapper> getList(List<AVUser> list) {
        List<UserWrapper> wrapperList;
        if (list == null) {
            return new ArrayList<>();
        }
        wrapperList = new ArrayList<>(list.size());
        for (AVUser user : list) {
            wrapperList.add(new UserWrapper(user));
        }
        return wrapperList;
    }

    public UserWrapper(AVUser avUser) {
        this.avUser = avUser;
    }

    public AVUser getAvUser() {
        return avUser;
    }

    public String getNickName() {
        return (String) avUser.get(NICK_NAME);
    }

    public void setNickName(String nickName) {
        avUser.put(NICK_NAME, nickName);
    }

    public String getUsername() {
        return avUser.getUsername();
    }

    public void setUsername(String userName) {
        avUser.setUsername(userName);
    }

    public void setPassword(String password) {
        avUser.setPassword(password);
    }

    public String getMobilePhoneNumber() {
        return avUser.getMobilePhoneNumber();
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        avUser.setMobilePhoneNumber(mobilePhoneNumber);
    }

    public void setLocationUpdateTime(long timeInMill) {
        Date date = new Date(timeInMill);
        avUser.put(LOCATION_UPDATE_TIME, date);
    }

    public long getLastLocationUpdateTime() {
        Date date = avUser.getDate(LOCATION_UPDATE_TIME);
        return date.getTime();
    }

    public AVGeoPoint getLocation() {
        return avUser.getAVGeoPoint(LOCATION);
    }

    public void setLocation(AVGeoPoint location) {
        avUser.put(LOCATION, location);
    }

    public boolean isLocationUpdating() {
        return avUser.getBoolean(LOCATION_UPDATE_STATE);
    }

    public void setLocationUpdateState(boolean locationUpdateState) {
        avUser.put(LOCATION_UPDATE_STATE, locationUpdateState);
    }

    public float getAccuracy() {
        return Float.parseFloat((String)avUser.get(ACCURACY));
    }

    public void setAccuracy(float accuracy) {
        avUser.put(ACCURACY, String.valueOf(accuracy));
    }

    public int getType() {
        return avUser.getInt(TYPE);
    }

    public void setType(int type) {
        avUser.put(TYPE, type);
    }

    public String getAvatarUrl() {
        return (String) avUser.get("avatarUrl");
    }

    public void setAvatarUrl(String avatarUrl) {
        avUser.put("avatarUrl", avatarUrl);
    }


    public void save() throws AVException {
        avUser.save();
    }

    public void saveInBackground() {
        avUser.saveInBackground();
    }

    public void saveInBackground(SaveCallback callback) {
        avUser.saveInBackground(callback);
    }

    public void signUpInBackground(SignUpCallback callback) {
        avUser.signUpInBackground(callback);
    }

    public static void logInInBackground(String userName, String password, LogInCallback callback) {
        AVUser.logInInBackground(userName, password, callback);
    }

    public static UserWrapper getCurrentUser() {
        UserWrapper wrapper = null;
        AVUser user = AVUser.getCurrentUser();
        if (user != null) {
            wrapper = new UserWrapper(user);
        }
        Log.i(TAG, "userWrapper:" + wrapper);
        return wrapper;
    }

    public String getObjectId() {
        return avUser.getObjectId();
    }

    public void logOut(){
        avUser.logOut();
    }


    public AVFile getAvatar(){
        return avUser.getAVFile(AVATAR);
    }

    public void setAvatar(AVFile avatar){
        avUser.put(AVATAR, avatar);
    }

    @Override
    public String toString() {
        return avUser.toString();
    }
}
