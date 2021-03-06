package com.example.manar.twitterclientchallenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Manar on 23/12/2017.
 * "See the good."
 */

public class UserLookUp implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("entities")
    @Expose
    private Entities entities;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("friends_count")
    @Expose
    private Integer friendsCount;
    @SerializedName("listed_count")
    @Expose
    private Integer listedCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("favourites_count")
    @Expose
    private Integer favouritesCount;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("statuses_count")
    @Expose
    private Integer statusesCount;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @SerializedName("is_translation_enabled")
    @Expose
    private Boolean isTranslationEnabled;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("profile_banner_url")
    @Expose
    private String profileBannerUrl;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @SerializedName("has_extended_profile")
    @Expose
    private Boolean hasExtendedProfile;
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @SerializedName("following")
    @Expose
    private Boolean following;
    @SerializedName("follow_request_sent")
    @Expose
    private Boolean followRequestSent;
    @SerializedName("notifications")
    @Expose
    private Boolean notifications;
    @SerializedName("translator_type")
    @Expose
    private String translatorType;

    protected UserLookUp(Parcel in) {
        id = in.readString();
        idStr = in.readString();
        name = in.readString();
        screenName = in.readString();
        location = in.readString();
        description = in.readString();
        url = in.readString();
        createdAt = in.readString();
        timeZone = in.readString();
        lang = in.readString();
        profileBackgroundColor = in.readString();
        profileBackgroundImageUrl = in.readString();
        profileBackgroundImageUrlHttps = in.readString();
        profileImageUrl = in.readString();
        profileImageUrlHttps = in.readString();
        profileBannerUrl = in.readString();
        profileLinkColor = in.readString();
        profileSidebarBorderColor = in.readString();
        profileSidebarFillColor = in.readString();
        profileTextColor = in.readString();
        translatorType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(idStr);
        dest.writeString(name);
        dest.writeString(screenName);
        dest.writeString(location);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(createdAt);
        dest.writeString(timeZone);
        dest.writeString(lang);
        dest.writeString(profileBackgroundColor);
        dest.writeString(profileBackgroundImageUrl);
        dest.writeString(profileBackgroundImageUrlHttps);
        dest.writeString(profileImageUrl);
        dest.writeString(profileImageUrlHttps);
        dest.writeString(profileBannerUrl);
        dest.writeString(profileLinkColor);
        dest.writeString(profileSidebarBorderColor);
        dest.writeString(profileSidebarFillColor);
        dest.writeString(profileTextColor);
        dest.writeString(translatorType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserLookUp> CREATOR = new Creator<UserLookUp>() {
        @Override
        public UserLookUp createFromParcel(Parcel in) {
            return new UserLookUp(in);
        }

        @Override
        public UserLookUp[] newArray(int size) {
            return new UserLookUp[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public Boolean getIsTranslationEnabled() {
        return isTranslationEnabled;
    }

    public void setIsTranslationEnabled(Boolean isTranslationEnabled) {
        this.isTranslationEnabled = isTranslationEnabled;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public void setProfileBannerUrl(String profileBannerUrl) {
        this.profileBannerUrl = profileBannerUrl;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Boolean getHasExtendedProfile() {
        return hasExtendedProfile;
    }

    public void setHasExtendedProfile(Boolean hasExtendedProfile) {
        this.hasExtendedProfile = hasExtendedProfile;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public Boolean getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public void setTranslatorType(String translatorType) {
        this.translatorType = translatorType;
    }

    public class Status{

        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("id_str")
        @Expose
        private String idStr;
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("truncated")
        @Expose
        private Boolean truncated;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("in_reply_to_status_id")
        @Expose
        private Object inReplyToStatusId;
        @SerializedName("in_reply_to_status_id_str")
        @Expose
        private Object inReplyToStatusIdStr;
        @SerializedName("in_reply_to_user_id")
        @Expose
        private String inReplyToUserId;
        @SerializedName("in_reply_to_user_id_str")
        @Expose
        private String inReplyToUserIdStr;
        @SerializedName("in_reply_to_screen_name")
        @Expose
        private String inReplyToScreenName;
        @SerializedName("geo")
        @Expose
        private Object geo;
        @SerializedName("coordinates")
        @Expose
        private Object coordinates;
        @SerializedName("place")
        @Expose
        private Object place;
        @SerializedName("contributors")
        @Expose
        private Object contributors;
        @SerializedName("is_quote_status")
        @Expose
        private Boolean isQuoteStatus;
        @SerializedName("retweet_count")
        @Expose
        private Integer retweetCount;
        @SerializedName("favorite_count")
        @Expose
        private Integer favoriteCount;
        @SerializedName("favorited")
        @Expose
        private Boolean favorited;
        @SerializedName("retweeted")
        @Expose
        private Boolean retweeted;
        @SerializedName("lang")
        @Expose
        private String lang;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdStr() {
            return idStr;
        }

        public void setIdStr(String idStr) {
            this.idStr = idStr;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Boolean getTruncated() {
            return truncated;
        }

        public void setTruncated(Boolean truncated) {
            this.truncated = truncated;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Object getInReplyToStatusId() {
            return inReplyToStatusId;
        }

        public void setInReplyToStatusId(Object inReplyToStatusId) {
            this.inReplyToStatusId = inReplyToStatusId;
        }

        public Object getInReplyToStatusIdStr() {
            return inReplyToStatusIdStr;
        }

        public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
            this.inReplyToStatusIdStr = inReplyToStatusIdStr;
        }

        public String getInReplyToUserId() {
            return inReplyToUserId;
        }

        public void setInReplyToUserId(String inReplyToUserId) {
            this.inReplyToUserId = inReplyToUserId;
        }

        public String getInReplyToUserIdStr() {
            return inReplyToUserIdStr;
        }

        public void setInReplyToUserIdStr(String inReplyToUserIdStr) {
            this.inReplyToUserIdStr = inReplyToUserIdStr;
        }

        public String getInReplyToScreenName() {
            return inReplyToScreenName;
        }

        public void setInReplyToScreenName(String inReplyToScreenName) {
            this.inReplyToScreenName = inReplyToScreenName;
        }

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public Object getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Object coordinates) {
            this.coordinates = coordinates;
        }

        public Object getPlace() {
            return place;
        }

        public void setPlace(Object place) {
            this.place = place;
        }

        public Object getContributors() {
            return contributors;
        }

        public void setContributors(Object contributors) {
            this.contributors = contributors;
        }

        public Boolean getIsQuoteStatus() {
            return isQuoteStatus;
        }

        public void setIsQuoteStatus(Boolean isQuoteStatus) {
            this.isQuoteStatus = isQuoteStatus;
        }

        public Integer getRetweetCount() {
            return retweetCount;
        }

        public void setRetweetCount(Integer retweetCount) {
            this.retweetCount = retweetCount;
        }

        public Integer getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(Integer favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public Boolean getFavorited() {
            return favorited;
        }

        public void setFavorited(Boolean favorited) {
            this.favorited = favorited;
        }

        public Boolean getRetweeted() {
            return retweeted;
        }

        public void setRetweeted(Boolean retweeted) {
            this.retweeted = retweeted;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

    }
    public class Url {

        @SerializedName("urls")
        @Expose
        private List<Url_> urls = null;

        public List<Url_> getUrls() {
            return urls;
        }

        public void setUrls(List<Url_> urls) {
            this.urls = urls;
        }

    }

    public class Url_ {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("expanded_url")
        @Expose
        private String expandedUrl;
        @SerializedName("display_url")
        @Expose
        private String displayUrl;
        @SerializedName("indices")
        @Expose
        private List<Integer> indices = null;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getExpandedUrl() {
            return expandedUrl;
        }

        public void setExpandedUrl(String expandedUrl) {
            this.expandedUrl = expandedUrl;
        }

        public String getDisplayUrl() {
            return displayUrl;
        }

        public void setDisplayUrl(String displayUrl) {
            this.displayUrl = displayUrl;
        }

        public List<Integer> getIndices() {
            return indices;
        }

        public void setIndices(List<Integer> indices) {
            this.indices = indices;
        }

    }

    public class Description {

        @SerializedName("urls")
        @Expose
        private List<Object> urls = null;

        public List<Object> getUrls() {
            return urls;
        }

        public void setUrls(List<Object> urls) {
            this.urls = urls;
        }

    }
    public class Entities {

        @SerializedName("url")
        @Expose
        private Url url;
        @SerializedName("description")
        @Expose
        private Description description;

        public Url getUrl() {
            return url;
        }

        public void setUrl(Url url) {
            this.url = url;
        }

        public Description getDescription() {
            return description;
        }

        public void setDescription(Description description) {
            this.description = description;
        }

    }
}