package top.naccl.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import top.naccl.entity.Category;
import top.naccl.entity.Tag;
import top.naccl.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 博客DTO
 * @Author: Naccl
 * @Date: 2020-08-27
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Blog {
	private Long id;
	private String title;//文章标题
	private String firstPicture;//文章首图，用于随机文章展示
	private String content;//文章正文
	private String description;//描述
	private Boolean published;//公开或私密
	private Boolean recommend;//推荐开关
	private Boolean appreciation;//赞赏开关
	private Boolean commentEnabled;//评论开关
	private Boolean top;//是否置顶
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer views;//浏览次数
	private Integer words;//文章字数
	private Integer readTime;//阅读时长(分钟)
	private String password;//密码保护

	private User user;//文章作者(因为是个人博客，也可以不加作者字段，暂且加上)
	private Category category;//文章分类
	private List<Tag> tags = new ArrayList<>();//文章标签

	private Object cate;//页面展示层传输的分类对象：正常情况下为 字符串 或 分类id
	private List<Object> tagList;//页面展示层传输的标签对象：正常情况下为 List<Integer>标签id 或 List<String>标签名
	// Getter 方法
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getFirstPicture() {
		return firstPicture;
	}

	public String getContent() {
		return content;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getPublished() {
		return published;
	}

	public Boolean getRecommend() {
		return recommend;
	}

	public Boolean getAppreciation() {
		return appreciation;
	}

	public Boolean getCommentEnabled() {
		return commentEnabled;
	}

	public Boolean getTop() {
		return top;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Integer getViews() {
		return views;
	}

	public Integer getWords() {
		return words;
	}

	public Integer getReadTime() {
		return readTime;
	}

	public String getPassword() {
		return password;
	}

	public User getUser() {
		return user;
	}

	public Category getCategory() {
		return category;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public Object getCate() {
		return cate;
	}

	public List<Object> getTagList() {
		return tagList;
	}

	// Setter 方法
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstPicture(String firstPicture) {
		this.firstPicture = firstPicture;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}

	public void setAppreciation(Boolean appreciation) {
		this.appreciation = appreciation;
	}

	public void setCommentEnabled(Boolean commentEnabled) {
		this.commentEnabled = commentEnabled;
	}

	public void setTop(Boolean top) {
		this.top = top;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public void setReadTime(Integer readTime) {
		this.readTime = readTime;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setCate(Object cate) {
		this.cate = cate;
	}

	public void setTagList(List<Object> tagList) {
		this.tagList = tagList;
	}
}
