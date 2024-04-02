package org.yeort.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
         description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
class CheckSum implements Callable<Integer> {

    @Parameters(index = "0", arity = "0..1", description = "The file whose checksum to calculate.",interactive = true)
    private File file;

    @Option(names = {"-a", "--algorithm"}, arity = "0..1", description = "MD5, SHA-1, SHA-256, ...", interactive = true)
    private String algorithm = "SHA-256";

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        return 0;
    }
    @Command(name = "add", description = "add a element", mixinStandardHelpOptions = true)
    static class AddCommand implements Callable<String>{
        public String call() throws Exception {
            System.out.println("执行加法的命令");
            return "0";
        }
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        String[] myargs = new String[]{"-h", "-a"};
//        int exitCode = new CommandLine(new CheckSum()).execute("-h");
        int exitCode = new CommandLine(new CheckSum()).addSubcommand(new AddCommand()).execute(myargs);
        System.exit(exitCode);
    }
}