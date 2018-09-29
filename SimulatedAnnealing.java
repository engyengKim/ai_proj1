
public class SimulatedAnnealing {
    // Calculate the acceptance probability

    public static double acceptProbability(int cost, int newCost, double temperature) {
        // If the new solution is better, accept it
        if (newCost < cost) {
            return 1.0;
        }

        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((cost - newCost) / temperature);
    }

    public static void main(String[] args) {
        // read file & create, add our cities
    	FileIO fileIO = new FileIO();
    	fileIO.readFile("res/input_662.txt");

        // Set initial temperature: temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize initial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual(); //randomly generated tour (path)

        System.out.println("Initial solution distance: " + currentSolution.getDistance());
        
        // Set current as best
        Tour best = new Tour(currentSolution.getTour());

       
        // Loop until system has cooled & limited time: 30s
        while (temp > 1) {
        	
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get a random positions in the tour
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);

            // Get cost of solutions
            int currentCost = currentSolution.getDistance();
            int neighbourCost = newSolution.getDistance();

            // Decide if we should accept the neighbour
            if (acceptProbability(currentCost, neighbourCost, temp) > Math.random()) {
                currentSolution = new Tour(newSolution.getTour());
            }
            
            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

           
            // Cool temperature
            temp *= 1-coolingRate;

        }
        
        // write final tour to "output.txt"
        

        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println("Tour: " + best);

    }

}