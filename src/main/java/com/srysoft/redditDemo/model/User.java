package com.srysoft.redditDemo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.srysoft.redditDemo.validator.PasswordMatch;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@PasswordMatch
public class User implements UserDetails {

	private static final long serialVersionUID = 5586954822607471468L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 8, max = 20)
	@Column(nullable = false, unique = true)
	private String email;

	@NonNull
	@Column(length = 100)
	private String password;
	
	@Transient
	@NotEmpty(message = "Please enter Password Confirmation")
	private String confirmPassword;

	//	@NonNull
	@Column(nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	@NotNull
	@NotEmpty(message = "You must enter First Name")
	private String firstName;

	@NotNull
	@NotEmpty(message = "You must enter Last Name")
	private String lastName;

	@NotNull
	@NotEmpty(message = "You must enter alias")
	@Column(nullable = false, unique = true)
	private String alias;
	
	@Transient
	@Setter(AccessLevel.NONE)
	private String fullName;
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	public void addRoles(Set<Role> roles) {
		roles.forEach(this::addRole);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		/*
			for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		*/

		// Use Lambda expression
		authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());

		return authorities;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public User(String email, String secret, boolean enable) {
		this.email = email;
		this.password = secret;
		this.enabled = enable;
	}

	public User(@NotNull @Size(min = 8, max = 20) String email, String password, boolean enabled,
			@NotNull @NotEmpty(message = "You must enter First Name") String firstName,
			@NotNull @NotEmpty(message = "You must enter Last Name") String lastName,
			@NotNull @NotEmpty(message = "You must enter alias") String alias) {
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.alias = alias;
	}
	
	

}
