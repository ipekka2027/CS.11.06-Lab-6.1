import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));
    }


    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int count = 0;
        int[] numbers = new int[countLinesInFile(fileName)];
        numbers = readFile(fileName);
            for(int i = 0; i<numbers.length-1; i++){
                if(numbers[i] < numbers[i+1]){
                    count++;
                }
            }
            return count;
        }


/** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] numbers = new int[countLinesInFile(fileName)];
        numbers = readFile(fileName);
        int count = 0;
        for(int i = 0; i<numbers.length-3; i++) {
            if (numbers[i + 1] + numbers[i + 2] + numbers[i + 3] > numbers[i] + numbers[i + 1] + numbers[i + 2]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        String[] movements = new String[linesInFile];

        int index = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            movements[index++] = scanner.nextLine();
        }

        int depth = 0;
        int horizontalPosition = 0;
        for (int i=0;i<movements.length;i++){
            String current = movements[i];
            String[] currentSplit = current.split(" ");
            int amount = Integer.parseInt(currentSplit[1]);
            if(currentSplit[0].equals("forward")){
                horizontalPosition += amount;
            }
            else if(currentSplit[0].equals("down")){
                depth += amount;
            }
            else{
                depth -= amount;
            }
        }
        return horizontalPosition * depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int linesInFile = countLinesInFile(filename);
        String[] movements = new String[linesInFile];

        int index = 0;
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            movements[index++] = scanner.nextLine();
        }

        int depth = 0;
        int horizontalPosition = 0;
        int aim = 0;
        for (int i=0;i<movements.length;i++){
            String current = movements[i];
            String[] currentSplit = current.split(" ");
            int amount = Integer.parseInt(currentSplit[1]);
            if(currentSplit[0].equals("forward")){
                horizontalPosition += amount;
                depth += aim * amount;
            }
            else if(currentSplit[0].equals("down")){
                aim += amount;
            }
            else{
                aim -= amount;
            }
        }
        return horizontalPosition * depth;
    }


    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}
