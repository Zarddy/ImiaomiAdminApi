package cn.imiaomi.admin.api.pojo;

import javax.persistence.*;

@Table(name = "imiao_mao")
public class ImiaoMao {
    @Id
    private Integer id = 0;

    @Column(name = "pin_id")
    private String pinId = "";

    @Column(name = "random_dir")
    private String randomDir = "";

    @Column(name = "pic_url")
    private String picUrl = "";

    private String source = "";

    @Column(name = "source_link")
    private String sourceLink = "";

    @Column(name = "like_count")
    private Integer likeCount = 0;

    @Column(name = "comment_count")
    private Integer commentCount = 0;

    @Column(name = "repin_count")
    private Integer repinCount = 0;

    private Integer state = 0;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return pin_id
     */
    public String getPinId() {
        return pinId;
    }

    /**
     * @param pinId
     */
    public void setPinId(String pinId) {
        this.pinId = pinId;
    }

    /**
     * @return random_dir
     */
    public String getRandomDir() {
        return randomDir;
    }

    /**
     * @param randomDir
     */
    public void setRandomDir(String randomDir) {
        this.randomDir = randomDir;
    }

    /**
     * @return pic_url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return source_link
     */
    public String getSourceLink() {
        return sourceLink;
    }

    /**
     * @param sourceLink
     */
    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    /**
     * @return like_count
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * @param likeCount
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * @return comment_count
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * @return repin_count
     */
    public Integer getRepinCount() {
        return repinCount;
    }

    /**
     * @param repinCount
     */
    public void setRepinCount(Integer repinCount) {
        this.repinCount = repinCount;
    }

    /**
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }
}