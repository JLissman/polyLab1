package Polymorph.src.Managers;



/**
 *
 * @author Jonathan & Salar
 */

public class DisplayManager
{
    private static DisplayManager m_instance = null;
    public static DisplayManager Instance()
    {
        if (m_instance == null)
            m_instance = new DisplayManager();

        return m_instance;
    }

    public void MultiInputChoice(String title, String... options)
    {
        System.out.println  ("||||||||||||||||--" + title + "--||||||||||||||||");
        System.out.println  ("|||");

        for (int i = 0; i < options.length; i++) {
            System.out.println("||| > " + (i+1) + ". " + options[i] );
        }

        System.out.println  ("|||");
        System.out.println  ("||||||||||||||||");
        System.out.println  ("||| > 0. EXIT ");
        System.out.println  ("||||||||||||||||");
    }

    public void MultiInfoLine(String title, String... text)
    {
        System.out.println  ("||||||||||||||||--" + title + "--||||||||||||||||");
        System.out.println  ("|||");
        for (int i = 0; i < text.length; i++) {
            System.out.println("||| > " + text[i] );
        }
        System.out.println  ("|||");
        System.out.println  ("||||||||||||||||");
        System.out.println  ("||| Press enter-key to return to menu... ");
        System.out.println  ("||||||||||||||||");
    }
    public void DisplayLines(String... line)
    {
        System.out.println("||||||||||||||||||||||||||");
        for (int i = 0; i < line.length; i++)
        {
            System.out.println("||| " + line[i]);
        }
    }
    public void InputChoice(String input)
    {
        System.out.println("*");
        System.out.println("*");
        System.out.print("[" + input + "] > ");
    }



}
