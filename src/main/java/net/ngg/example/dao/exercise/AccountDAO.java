package net.ngg.example.dao.exercise;

import net.ngg.example.entity.exercise.Account;

public interface AccountDAO {
	public Account findByEmail(String email);
}
