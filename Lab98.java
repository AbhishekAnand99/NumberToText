String[] result = new String[1];

		result[0] = "";

		int i, num;
		Scanner sc = new Scanner(System.in);

		System.out.println("ENTER THE NUMBER");
		num = sc.nextInt();

		if (ConvertNumberToText(num, result) == true)

			System.out.println(num + "\t" + result[0]);

	}

	static public boolean HelperConvertNumberToText(int num, String[] result)

	{

		String[] strones = {

		"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",

		"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",

		"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",

		};

		String[] strtens = {

		"Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty",

		"Seventy", "Eighty", "Ninety", "Hundred"

		};

		result[0] = "";

		int single, tens, hundreds;

		if (num > 1000)

			return false;

		hundreds = num / 100;

		num = num - hundreds * 100;

		if (num < 20)

		{

			tens = 0; // special case

			single = num;

		}

		else

		{

			tens = num / 10;

			num = num - tens * 10;

			single = num;

		}

		if (hundreds > 0)

		{

			result[0] += strones[hundreds - 1];

			result[0] += " Hundred ";

		}

		if (tens > 0)

		{

			result[0] += strtens[tens - 1];

			result[0] += " ";

		}

		if (single > 0)

		{

			result[0] += strones[single - 1];

			result[0] += " ";

		}

		return true;

	}

	static public boolean ConvertNumberToText(int num, String[] result)

	{

		String tempString[] = new String[1];

		tempString[0] = "";

		int thousands;

		int temp;

		result[0] = "";

		if (num < 0 || num > 100000)

		{

			System.out.println(num + " \tNot Supported");

			return false;

		}

		if (num == 0)

		{

			System.out.println(num + " \tZero");

			return false;

		}

		if (num < 1000)

		{

			HelperConvertNumberToText(num, tempString);

			result[0] += tempString[0];

		}

		else

		{

			thousands = num / 1000;

			temp = num - thousands * 1000;

			HelperConvertNumberToText(thousands, tempString);

			result[0] += tempString[0];

			result[0] += "Thousand ";

			HelperConvertNumberToText(temp, tempString);

			result[0] += tempString[0];

		}

		return true;

	}
}