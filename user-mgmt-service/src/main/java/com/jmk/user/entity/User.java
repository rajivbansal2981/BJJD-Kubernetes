package com.jmk.user.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.enums.MessageSent;
import com.jmk.enums.Status;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="username")
	private String username = null;

	@Column(name="display_name")
	private String displayName = null;

	@Column(name="password")
	private String password = null;
	
	@Column(name="security")
	private String security = null;
	
	@Column(name="encryption")
	private String encryption = null;
	
	@Column(name="login_attempt")
	private Integer loginAttempt = null;
	
	@Column(name="fail_attempt")
	private Integer failAttempt = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sms_Sent")
	private MessageSent smsSent=null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="email_Sent")
	private MessageSent emailSent=null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status = null;

	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private Profile profile = null;

	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private Identity identity = null;

	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLE",
	joinColumns= {@JoinColumn(name="user_id")},
	inverseJoinColumns= {@JoinColumn(name="role_id")})
	private Set<Role> roles=new HashSet<>();
	
	@Column(name="group_id")
	private Integer groupId = null;
	
	@Column(name="created_by")
	private Integer createdBy = null;
	
	@Column(name="created_on")
	private Timestamp createdOn=null;
	
	@Column(name="when_modified")
	private Timestamp whenModified=null;
	
	@Version
	private Long version = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	public Integer getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(Integer loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public Integer getFailAttempt() {
		return failAttempt;
	}

	public void setFailAttempt(Integer failAttempt) {
		this.failAttempt = failAttempt;
	}

	public MessageSent getSmsSent() {
		return smsSent;
	}

	public void setSmsSent(MessageSent smsSent) {
		this.smsSent = smsSent;
	}

	public MessageSent getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(MessageSent emailSent) {
		this.emailSent = emailSent;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getWhenModified() {
		return whenModified;
	}

	public void setWhenModified(Timestamp whenModified) {
		this.whenModified = whenModified;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
}
