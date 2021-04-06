package com.example.self.normalpractice.rpc;

public class proxy implements com.example.self.normalpractice.rpc.UserService {

	@Override
	public com.example.self.normalpractice.rpc.User getUserById(int param0) {
		System.out.println("数据库操作, 并获取执行结果...");
		return null;
	}
}