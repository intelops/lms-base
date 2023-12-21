package com.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDto {
	  
	     private int id;
	      private String fullName=null;
	    
	      private String experience=null;
	    private String profilePhoto=null;
	      private String skills=null;
	      private String postalCode=null;
	      private String education=null;
	      private String gender=null;
	      private String dateOfBirth=null;
	      private int type=0;
	      private boolean isActive=true;
	      private String linkedin;
	      private String twitter;
	      private String aboutMe;
	      private String medium;
	      private String title;
	   private List<UserRoleDto> list;
	   
	  
		  	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

			public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

			public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

			public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

			public List<UserRoleDto> getList() {
		return list;
	}
		  	
		     private Boolean promotionANDCourseRecommendation=false;
		   
		     private Boolean announcementsFromInstructor=false;
		   
		     private Boolean dontSendPromotionalEmail=false;
		    
		     private Boolean individualNotification=false;
		   
		     private Boolean digestNotification=false;
		     
	public Boolean getPromotionANDCourseRecommendation() {
				return promotionANDCourseRecommendation;
			}

			public void setPromotionANDCourseRecommendation(Boolean promotionANDCourseRecommendation) {
				this.promotionANDCourseRecommendation = promotionANDCourseRecommendation;
			}

			public Boolean getAnnouncementsFromInstructor() {
				return announcementsFromInstructor;
			}

			public void setAnnouncementsFromInstructor(Boolean announcementsFromInstructor) {
				this.announcementsFromInstructor = announcementsFromInstructor;
			}

			public Boolean getDontSendPromotionalEmail() {
				return dontSendPromotionalEmail;
			}

			public void setDontSendPromotionalEmail(Boolean dontSendPromotionalEmail) {
				this.dontSendPromotionalEmail = dontSendPromotionalEmail;
			}

			public Boolean getIndividualNotification() {
				return individualNotification;
			}

			public void setIndividualNotification(Boolean individualNotification) {
				this.individualNotification = individualNotification;
			}

			public Boolean getDigestNotification() {
				return digestNotification;
			}

			public void setDigestNotification(Boolean digestNotification) {
				this.digestNotification = digestNotification;
			}

	public String getGender() {
				return gender;
			}

			public void setGender(String gender) {
				this.gender = gender;
			}

			public String getDateOfBirth() {
				return dateOfBirth;
			}

			public void setDateOfBirth(String dateOfBirth) {
				this.dateOfBirth = dateOfBirth;
			}

	public void setList(List<UserRoleDto> list) {
		this.list = list;
	}

			public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getExperience() {
	  		return experience;
	  	}

	  	public void setExperience(String experience) {
	  		this.experience = experience;
	  	}

	  	public String getSkills() {
	  		return skills;
	  	}

	  	public void setSkills(String skills) {
	  		this.skills = skills;
	  	}

	  	public String getEducation() {
	  		return education;
	  	}

	  	public void setEducation(String education) {
	  		this.education = education;
	  	}

	  
	  	public Boolean getEmailOtpExipry() {
	  		return emailOtpExipry;
	  	}

	  	public void setEmailOtpExipry(Boolean emailOtpExipry) {
	  		this.emailOtpExipry = emailOtpExipry;
	  	}

	  	public Boolean getPhonenumberOtpExpiry() {
	  		return phonenumberOtpExpiry;
	  	}

	  	public void setPhonenumberOtpExpiry(Boolean phonenumberOtpExpiry) {
	  		this.phonenumberOtpExpiry = phonenumberOtpExpiry;
	  	}

	  	public Boolean getTermsandconditions() {
	  		return termsandconditions;
	  	}
	  	
	      private String password=null;
	 
	  private String phonenumber=null;
	
	  private String countryCode=null;
	  
	  private Boolean termsandconditions=false;
	  	
	      private String token=null;
	  	
	      private String emailOtp=null;
	  
	      private String phonenumberOtp=null;
	  	
	      private Boolean emailOtpExipry=true;
	  	
	      private Boolean phonenumberOtpExpiry=true;
	  	private String addressline1=null;
	  	private String addressline2=null;

	      private String email=null;
	      
	      private int orgId=0;
		  	
	      private int roleId=0;
	     
	  	private String city=null;
	  
	  	private String country=null;
	 
	  	private  String state=null;
	  	
		private String roleName=null;
		    private int courseId=0;
		  
		    private int batchId=0;
		
		    private int branchId=0;
		    private int organizationId=0;
		    
		public int getOrganizationId() {
				return organizationId;
			}

			public void setOrganizationId(int organizationId) {
				this.organizationId = organizationId;
			}

					public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getCountry() {
				return country;
			}

			public void setCountry(String country) {
				this.country = country;
			}

			public String getState() {
				return state;
			}

			public void setState(String state) {
				this.state = state;
			}

					public int getCourseId() {
				return courseId;
			}

			public void setCourseId(int courseId) {
				this.courseId = courseId;
			}

			public int getBatchId() {
				return batchId;
			}

			public void setBatchId(int batchId) {
				this.batchId = batchId;
			}

			public int getBranchId() {
				return branchId;
			}

			public void setBranchId(int branchId) {
				this.branchId = branchId;
			}

		public int getRoleId() {
			return roleId;
		}

		public void setRoleId(int roleId) {
			this.roleId = roleId;
		}

		public int getOrgId() {
			return orgId;
		}

		public void setOrgId(int orgId) {
			this.orgId = orgId;
		}

		
		
		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public String getPhonenumber() {
	  		return phonenumber;
	  	}

	  	public void setPhonenumber(String phonenumber) {
	  		this.phonenumber = phonenumber;
	  	}

	  	public Boolean isTermsandconditions() {
	  		return termsandconditions;
	  	}

	  	public void setTermsandconditions(Boolean termsandconditions) {
	  		this.termsandconditions = termsandconditions;
	  	}
	  	
	    

	  	public String getCountryCode() {
	  		return countryCode;
	  	}

	  	public void setCountryCode(String countryCode) {
	  		this.countryCode = countryCode;
	  	}

	
	  	public String getEmailOtp() {
	  		return emailOtp;
	  	}

	  	public void setEmailOtp(String emailOtp) {
	  		this.emailOtp = emailOtp;
	  	}

	  	public String getPhonenumberOtp() {
	  		return phonenumberOtp;
	  	}

	  	public void setPhonenumberOtp(String phonenumberOtp) {
	  		this.phonenumberOtp = phonenumberOtp;
	  	}

	  	public boolean isEmailOtpExipry() {
	  		return emailOtpExipry;
	  	}

	  	public void setEmailOtpExipry(boolean emailOtpExipry) {
	  		this.emailOtpExipry = emailOtpExipry;
	  	}

	  	public boolean isPhonenumberOtpExpiry() {
	  		return phonenumberOtpExpiry;
	  	}

	  	public void setPhonenumberOtpExpiry(boolean phonenumberOtpExpiry) {
	  		this.phonenumberOtpExpiry = phonenumberOtpExpiry;
	  	}

	  	public String getPhoneNumber() {
	  		return phonenumber;
	  	}

	  	public void setPhoneNumber(String phonenumber) {
	  		this.phonenumber = phonenumber;
	  	}

	  
	      public String getToken() {
	  		return token;
	  	}

	  	public void setToken(String token) {
	  		this.token = token;
	  	}

	  	public String getEmail() {
	  		return email;
	  	}

	  	public void setEmail(String email) {
	  		this.email = email;
	  	}

	      public String getPassword() {
	          return password;
	      }

	      public void setPassword(String password) {
	          this.password = password;
	      }

		public String getAddressline1() {
			return addressline1;
		}

		public void setAddressline1(String addressline1) {
			this.addressline1 = addressline1;
		}

		public String getAddressline2() {
			return addressline2;
		}

		public void setAddressline2(String addressline2) {
			this.addressline2 = addressline2;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		

}
