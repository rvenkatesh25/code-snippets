package com.yahoo.project;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;

/**
 * @author viyer
 * @version 0.1 Build 10/9/15.
 */
@Parameters(commandDescription = "Migrate ACT and ClientDB data to Sherpa tables")
public class CliTool {
    JCommander commandParser;

    @Parameter(names = {"--help", "-h"}, help=true, description = "Print command usage")
    boolean help;

    public CliTool() {
        this.commandParser = new JCommander();
        commandParser.setProgramName("act-data-migration");
        commandParser.addObject(this);
    }

    public int run(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("No arguments passed");
            }

            commandParser.parse(args);

            if (help) {
                commandParser.usage();
                return 0;
            }

            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e instanceof ParameterException || e instanceof IllegalArgumentException) {
                commandParser.usage();
            }
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        CliTool cliTool = new CliTool();
        int ret = cliTool.run(args);

        System.exit(ret);
    }
}
