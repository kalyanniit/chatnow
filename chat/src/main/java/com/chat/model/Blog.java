
	package com.chat.model;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;

	@Entity
	public class Blog {
		@Id@GeneratedValue
		private int blog_id;
		private String blogTitle;
		private String blogDescription;
		private String date;
		private String postedBy;
		private String category;
		public int getBlog_id() {
			return blog_id;
		}
		public void setBlog_id(int blog_id) {
			this.blog_id = blog_id;
		}
		public String getBlogTitle() {
			return blogTitle;
		}
		public void setBlogTitle(String blogTitle) {
			this.blogTitle = blogTitle;
		}
		public String getBlogDescription() {
			return blogDescription;
		}
		public void setBlogDescription(String blogDescription) {
			this.blogDescription = blogDescription;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getPostedBy() {
			return postedBy;
		}
		public void setPostedBy(String postedBy) {
			this.postedBy = postedBy;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		
		
		

	}
