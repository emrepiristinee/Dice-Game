import java.io.FileWriter;
import java.io.IOException;

public class SLL {
	private Node head;
	private Node namehead;

	public void add(Object dataToAdd) {
		Node newnode = new Node(dataToAdd);
		if (head == null) {
			head = newnode;
		} else {
			Node temp = head;
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newnode);
		}
	}

	public void Sortadd(Object dataToAdd, Object namedataToAdd) {
		if (head == null) { // inserting first element
			Node newnode = new Node(dataToAdd);
			head = newnode;
			Node newnamenode = new Node(namedataToAdd);
			namehead = newnamenode;
		} else if ((Integer) dataToAdd > (Integer) head.getData()) { // inserting to the front
			Node newnode = new Node(dataToAdd);
			newnode.setLink(head);
			head = newnode;
			Node newnamenode = new Node(namedataToAdd);
			newnamenode.setLink(namehead);
			namehead = newnamenode;

		} else { // inserting in between two nodes and inserting to the last
			Node temp = head;
			Node nametemp = namehead;
			Node previous = null;
			Node nameprevious = null;
			while (temp != null && (Integer) dataToAdd <= (Integer) temp.getData()) {
				previous = temp;
				temp = temp.getLink();
				nameprevious = nametemp;
				nametemp = nametemp.getLink();
			}
			if (temp == null) { // inserting to the last
				Node newnode = new Node(dataToAdd);
				previous.setLink(newnode);
				Node newnamenode = new Node(namedataToAdd);
				nameprevious.setLink(newnamenode);
			} else { // inserting in between two nodes
				Node newnode = new Node(dataToAdd);
				newnode.setLink(temp);
				previous.setLink(newnode);
				Node newnamenode = new Node(namedataToAdd);
				newnamenode.setLink(nametemp);
				nameprevious.setLink(newnamenode);
			}
		}
	}

	public void delete(Object dataToDelete) {
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			while (head != null && (Integer) head.getData() == (Integer) dataToDelete) {
				head = head.getLink();
			}

			Node temp = head;
			Node previous = null;
			while (temp != null) {
				if ((Integer) temp.getData() == (Integer) dataToDelete) {
					previous.setLink(temp.getLink());
					temp = previous;
					break;
				}
				previous = temp;
				temp = temp.getLink();
			}
		}
	}

	public int size() {
		int count = 0;
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			Node temp = head;
			while (temp != null) {
				count++;
				temp = temp.getLink();
			}
		}
		return count;
	}

	public void print() {
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();

			}
		}
	}

	public void printNameandScore() {
		System.out.println("Top-10 result in high score table: ");
		int i = 0;
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			Node temp = head;
			Node nametemp = namehead;
			while (i < 10) {
				System.out.print(nametemp.getData() + " ");
				nametemp = nametemp.getLink();
				System.out.print(temp.getData() + "\n");
				temp = temp.getLink();
				i++;
			}
		}
	}

	public void WriteFile() throws IOException {
		FileWriter fw = new FileWriter("NewHighScoreTable.txt"); // writes new High Score Table in .txt
		int i = 0, score = 0;
		String name = "";
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			Node temp = head;
			Node nametemp = namehead;
			while (i < 10) {
				name = (String) nametemp.getData();
				score = (int) temp.getData();
				fw.write(name + " " + score + "\n"); // write in .txt
				nametemp = nametemp.getLink();
				temp = temp.getLink();
				i++;
			}
		}
		fw.close();
	}

	public int check() {
		int score = 0;
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
		Node temp = head;
		while (temp != null) {
			switch ((Integer) temp.getData()) {
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			case 4:
				count4++;
				break;
			case 5:
				count5++;
				break;
			case 6:
				count6++;
				break;
			}
			temp = temp.getLink();

			if (count1 > 0 && count2 > 0 && count3 > 0 && count4 > 0 && count5 > 0 && count6 > 0) {
				for (int i = 1; i < 7; i++) {
					delete(i);
				}
				count1--;
				count2--;
				count3--;
				count4--;
				count5--;
				count6--;
				score += 30;
			} else if (count1 == 4 || count2 == 4 || count3 == 4 || count4 == 4 || count5 == 4 || count6 == 4) {
				for (int i = 0; i < 4; i++) {
					if (count1 == 4) {
						delete(1);
					} else if (count2 == 4) {
						delete(2);
					} else if (count3 == 4) {
						delete(3);
					} else if (count4 == 4) {
						delete(4);
					} else if (count5 == 4) {
						delete(5);
					} else if (count6 == 4) {
						delete(6);
					}
				}
				if (count1 == 4) {
					count1 -= 4;
				} else if (count2 == 4) {
					count2 -= 4;
				} else if (count3 == 4) {
					count3 -= 4;
				} else if (count4 == 4) {
					count4 -= 4;
				} else if (count5 == 4) {
					count5 -= 4;
				} else if (count6 == 4) {
					count6 -= 4;
				}
				score += 10;
			}

		}
		return score;

	}
}
