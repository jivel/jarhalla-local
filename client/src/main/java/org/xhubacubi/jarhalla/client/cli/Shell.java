/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xhubacubi.jarhalla.client.cli;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import jline.ArgumentCompletor;
import jline.ConsoleReader;
import jline.SimpleCompletor;
import org.xhubacubi.jarhalla.client.cli.util.ConsoleUtil;

/**
 * 
 * Codigo basado en el ejemplo de: sandarenu
 *
 */
public class Shell {
	private String[] commandsList;
        private ConsoleUtil console ;
	public void init() {
		commandsList = new String[] { "help", "status", "searchJar", "searchClass", "addRepo","deleteRepo", "resultSize","showRepos", "listRepos" ,"exit" };
                console = new ConsoleUtil();
	}

	public void run() throws IOException {
		welcome();
		ConsoleReader reader = new ConsoleReader();
		reader.setBellEnabled(false);
		List completors = new LinkedList();

		completors.add(new SimpleCompletor(commandsList));
		reader.addCompletor(new ArgumentCompletor(completors));

		String line;
		PrintWriter out = new PrintWriter(System.out);

		while ((line = readLine(reader, "")) != null) {
			if ("help".equals(line)) {
				help();
			} else if ("status".equals(line)) {
				console.status();
			} else if ("showRepos".equals(line)) {
				console.showRepos();
			} else if ("exit".equals(line)) {
				System.out.println("Exiting application");
				return;
			} else {
				System.out
						.println("Comando no reconocdo, "
                                                 + "Para ver los comandos disponibles pulsa TAB. Pulsa \"help\" seguido de ENTER.");
			}
			out.flush();
		}
	}

	private void welcome() {
		System.out.println("Bienvenido Jarhalla-Local version CLI. \n"
                                 + "Para ver los comandos disponibles pulsa TAB. O teclea \"help\" seguido de ENTER.");

	}

	private void help() {
		System.out.println("help		- Show help");
		System.out.println("action1		- Execute action1");
		System.out.println("action2		- Execute action2");
		System.out.println("exit        - Exit the app");

	}

	private String readLine(ConsoleReader reader, String promtMessage)
			throws IOException {
		String line = reader.readLine(promtMessage + "\njarhalla> ");
		return line.trim();
	}

}
