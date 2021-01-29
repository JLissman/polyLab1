package Polymorph.src.Managers;


/**
 *
 * @author Jonathan & Salar
 */

public class UIManager
{
    private static UIManager m_instance = null;
    public static UIManager Instance()
    {
        if (m_instance == null)
            m_instance = new UIManager();

        return m_instance;
    }

    public void DisplayMultiChoice(String menuTitle, String... options)
    {
        if(options.length <= 0)
            return;

        System.out.println  ("||||||||||||||||--" + menuTitle + "--||||||||||||||||");
        System.out.println  ("|||");

        for (int i = 0; i < options.length; i++) {
            System.out.println("||| > " + (i+1) + ". " + options[i] );
        }

        System.out.println  ("|||");
        System.out.println  ("||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println  ("||| > 0. exit ");
        System.out.println  ("||||||||||||||||||||||||||||||||||||||||||||");
        System.out.print("[Input] > ");
    }
}
