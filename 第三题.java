class TestDemo
{
	public static void main(String[] args) {  
		Scanner in = new Scanner(System.in);  
        String str1 = in.nextLine();  
        String str2 = in.nextLine();  
		System.out.println(getString(str1,str2));
	}
	public static StringBuilder getString(String str1,String str2){
		StringBuilder sb=new StringBuilder();
		char[] str3=str1.toCharArray();
		char[] str4=str2.toCharArray();
		int t=0;
		for(int i=0;i<str3.length;i++){
			for(int j=t;j<str4.length;j++){
				if(str3[i]==str4[j])
				{
					sb.append(str4[j]);
					t=j;
				}
			}
		}
		return sb;
	}
}
