package pastaBar;

import java.util.Scanner;

public class PastaBar {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String[] phoneNumbers = { "063111111", "063222222", "063333333", "064444444", "065555555", "066666666" };

		String[] ingridients = { "Makarone", "Spagete", "Bolognese", "Curetina", "Govedja prsuta", "Slanina",
				"Piletina", "4 sira", "Dimljeni sir", "Parmezan", "Pavlaka", "Pesto sos", "Napolitana", "Povrce mix",
				"Pecurke", "Kutija" };
		int[] prices = { 50, 60, 120, 120, 140, 100, 100, 100, 80, 50, 80, 80, 80, 50, 50, 20 };

		boolean stopOrder = false;
		int orderPrice = 0;

		System.out.println("Izvolite!! ");

		while (stopOrder == false) {

			System.out.print("Izaberite sastojak za pastu: ");
			String ingridient = s.next();

			if (!ingridient.equals("poruci")) {

				orderPrice = orderPrice + prices[findIngredient(ingridients, ingridient)];

			} else {

				System.out.print("Unesite broj telefona: ");
				String phone = s.next();

				if (isRegularCustomer(phoneNumbers, phone) == true) {
					
					orderPrice = orderPrice - ( orderPrice * 10/100);
					System.out.println(orderPrice);
				}

			}
		}

	}

	public static int findIngredient(String[] ingredients, String ingredientName) {

		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].equals(ingredientName)) {
				return i;
			}
		}
		return 0;
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
