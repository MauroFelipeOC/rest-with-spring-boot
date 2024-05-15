package com.example.data.vo.v1.security;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TokenVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private Boolean authenticaded;
	private Date created;
	private Date expiration;
	private String accessToken;
	private String RefreshToken;
	
	public TokenVO() {}

	public TokenVO(String username, Boolean authenticaded, Date created, Date expiration, String accessToken,
			String refreshToken) {
		this.username = username;
		this.authenticaded = authenticaded;
		this.created = created;
		this.expiration = expiration;
		this.accessToken = accessToken;
		RefreshToken = refreshToken;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getAuthenticaded() {
		return authenticaded;
	}

	public void setAuthenticaded(Boolean authenticaded) {
		this.authenticaded = authenticaded;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return RefreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		RefreshToken = refreshToken;
	}

	@Override
	public int hashCode() {
		return Objects.hash(RefreshToken, accessToken, authenticaded, created, expiration, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenVO other = (TokenVO) obj;
		return Objects.equals(RefreshToken, other.RefreshToken) && Objects.equals(accessToken, other.accessToken)
				&& Objects.equals(authenticaded, other.authenticaded) && Objects.equals(created, other.created)
				&& Objects.equals(expiration, other.expiration) && Objects.equals(username, other.username);
	}
}
