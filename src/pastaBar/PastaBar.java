package pastaBar;

import java.util.Scanner;

public class PastaBar {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String[] phoneNumbers = { "063111111", "063222222", "063333333", "064444444", "065555555", "066666666" };

		String[] ingredients = { "makarone", "spagete", "bolognese", "curetina", "govedja prsuta", "slanina",
				"piletina", "4 sira", "dimljeni sir", "parmezan", "pavlaka", "pesto sos", "napolitana", "povrce mix",
				"pecurke", "kutija" };
		int[] prices = { 50, 60, 120, 120, 140, 100, 100, 100, 80, 50, 80, 80, 80, 50, 50, 20 };

		boolean stopOrder = false;
		int orderPrice = 0;
		String ordered = "";
		String ingredient = "";

		System.out.println("Izvolite!! ");

		while (stopOrder == false) {
			
			System.out.println("Izaberite sastojak za pastu: ");
			ingredient = s.nextLine();
			
			ingredient = ingredient.toLowerCase();

			if (ingredient.equals("poruci")) {

				if (orderPrice != 0) {
					System.out.print("Unesite broj telefona: ");
					String phone = s.next();
					System.out.println();

					if (isRegularCustomer(phoneNumbers, phone) == true) {

						orderPrice = orderPrice - (orderPrice * 10 / 100);

						System.out.println("Dobicete popust redovne musterije od 10 %");

					}
					stopOrder = true;
					System.out.println("Vasa pasta iznosi " + orderPrice + "rsd");
					System.out.println("Prijatno!");

				} else {

					System.out.println("Nista niste porucili");
				}

			} else if (findIngredient(ingredients, ingredient) >= 0
					&& findIngredient(ingredients, ingredient) < ingredients.length) {

				orderPrice = orderPrice + prices[findIngredient(ingredients, ingredient)];

				System.out.println();
				
				ordered = ingredients[findIngredient(ingredients, ingredient)] + ", " + ordered;
				
				System.out.println("Uzeli ste " + ordered + " ukupno " + orderPrice + "rsd");

			} else {
				System.out.println();
				System.out.println("Izvinite, ali trenutno nemamo taj sastojak");
				System.out.println("Probajte neki drugi sa menija :)");

				for (int i = 0; i < ingredients.length; i++) {
					System.out.print(ingredients[i] + ", ");
				}
				System.out.println();
				System.out.println();
			}
			System.out.println();
		}

	}

	public static int findIngredient(String[] ingredients, String ingredientName) {

		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].equals(ingredientName)) {
				return i;
			}
		}
		return 99;
	}

	public static boolean isRegularCustomer(String[] phoneNumbers, String phone) {

		for (int i = 0; i < phoneNumbers.length; i++) {
			if (phoneNumbers[i].equals(phone)) {
				return true;
			}
		}

		return false;
	}

}
