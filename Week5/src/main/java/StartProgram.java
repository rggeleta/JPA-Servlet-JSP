import java.util.List;
import java.util.Scanner;

import model.ListItem;
import model.ListOfTemp;

/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Oct 5, 2021
 */
public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static StartProgram lth = new StartProgram();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a temp: ");
			int temperature = in.nextInt();
			
			ListOfTemp toAdd = new ListOfTemp();
			lth.insertTemp(toAdd);

		}

		private void insertTemp(ListOfTemp toAdd) {
			// TODO Auto-generated method stub
			
		}
		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the temp to delete: ");
			int temperature = in.nextInt();
			ListOfTemp toDelete = new ListOfTemp();
			lth.deleteItem(toDelete);

		}

		/**
		 * @param toDelete
		 */
		private void deleteItem(ListOfTemp toDelete) {
			// TODO Auto-generated method stub
			
		}
		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListOfTemp> allItems = lth.showAllItems();
			for(ListOfTemp singleItem: allItems) {
				System.out.println(singleItem.returnTempDetails());
			}

}

		/**
		 * @return
		 */
		private List<ListOfTemp> showAllItems() {
			// TODO Auto-generated method stub
			return null;
		}
}
