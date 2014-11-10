import java.awt.event.KeyEvent;

public class Tank {

	/**
	 * A list of all possible keybindings
	 */
	private static final int keybindings[][] = {
			{ KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_W,
					KeyEvent.VK_C },
			{ KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_I,
					KeyEvent.VK_N } };

	/**
	 * The serial number of the next tank (note that, because it is static, this
	 * variable is shared by _all_ tanks at the class level.
	 */
	private static int nextSerialNumber = 0;
	
	/**
	 * The serial number of _this_ tank.
	 */
	private int serialNumber;

	/**
	 * _This_ tank's keybinding
	 */
	private int keybinding[];

	public Tank() {
		/*
		 * save our serial number and then increment the serialNumber counter so the next tank gets a
		 * _different_ keybinding
		 */
		serialNumber = nextSerialNumber;
		nextSerialNumber++;

		/* pick the next keybinding from the list (we'll run out quickly!) */
		keybinding = keybindings[serialNumber];

		/* print the keybinding to check our work */
		System.out.println(keybinding);
	}
}
