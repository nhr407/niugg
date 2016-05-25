package net.ngg.example.dao;

import net.ngg.example.entity.Account;

public interface AccountDAO {
	public Account findByEmail(String email);
}
