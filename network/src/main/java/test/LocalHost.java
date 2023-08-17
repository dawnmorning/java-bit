package test;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress =  InetAddress.getLocalHost();
			String name =  inetAddress.getHostName();
			String address =  inetAddress.getHostAddress();
			System.out.println(inetAddress);
			System.out.println(address);
			System.out.println(name);
			
			// 물음표짓게 만들어~
			byte[] ipAddress =  inetAddress.getAddress();
			for (byte b : ipAddress) {
				System.out.println(b& 0x000000ff);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
