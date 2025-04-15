package edu.trincoll;

// GalacticSortingTest.java
public class GalacticSortingTest {
    
    private static final int RANDOM_DATASET_SIZE = 1_000_000;
    private static final int PLANETARY_AGES_SIZE = 500_000;
    private static final int STAR_TEMPERATURES_SIZE = 750_000;
    private static final int GALAXY_DISTANCES_SIZE = 2_000_000;
    
    public static void main(String[] args) {
        System.out.println("=== GALACTIC SORTING CHALLENGE: PERFORMANCE ANALYSIS ===\n");
        
        System.out.println("Generating cosmic datasets...");
        Integer[] randomCelestialObjects = generateRandomCelestialObjects();
        Integer[] planetaryAges = generatePlanetaryAges();
        Integer[] starTemperatures = generateStarTemperatures();
        Integer[] galaxyDistances = generateGalaxyDistances();
        System.out.println("All datasets generated successfully!\n");
        
        testAllAlgorithms(randomCelestialObjects, "Random Celestial Objects");
        testAllAlgorithms(planetaryAges, "Planetary Ages");
        testAllAlgorithms(starTemperatures, "Star Temperatures");
        testAllAlgorithms(galaxyDistances, "Galaxy Distances");
    }
    
    private static void testAllAlgorithms(Integer[] dataset, String datasetName) {
        System.out.println("Testing algorithms on " + datasetName + "...");
        
        // Clone arrays for each algorithm
        Integer[] qsArray = cloneArray(dataset);
        Integer[] mmsArray = cloneArray(dataset);
        int[] rsArray = convertToPrimitive(dataset);
        int[] grsArray = convertToPrimitive(dataset);
        
        // Test Quantum Quick Sort
        NebulaMergeSort<Integer> nebulaMergeSort = new NebulaMergeSort<>();
        long start = System.currentTimeMillis();
        nebulaMergeSort.sort(mmsArray);
        long time = System.currentTimeMillis() - start;
        System.out.println("  Nebula Merge Sort: " + time + "ms, Comparisons: " + nebulaMergeSort.getComparisons());
        
        // Test Galactic Radix Sort
        GalacticRadixSort galacticRadix = new GalacticRadixSort();
        start = System.currentTimeMillis();
        galacticRadix.sort(grsArray);
        time = System.currentTimeMillis() - start;
        System.out.println("  Galactic Radix Sort: " + time + "ms");
    }
    
    private static Integer[] cloneArray(Integer[] original) {
        Integer[] copy = new Integer[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
    
    private static int[] convertToPrimitive(Integer[] array) {
        int[] primitive = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            primitive[i] = array[i];
        }
        return primitive;
    }
    
    private static Integer[] generateRandomCelestialObjects() {
        Integer[] data = new Integer[RANDOM_DATASET_SIZE];
        for (int i = 0; i < RANDOM_DATASET_SIZE; i++) {
            data[i] = (int) (Math.random() * 1_000_000);
        }
        return data;
    }
    
    private static Integer[] generatePlanetaryAges() {
        Integer[] data = new Integer[PLANETARY_AGES_SIZE];
        for (int i = 0; i < PLANETARY_AGES_SIZE; i++) {
            data[i] = i + (int) (Math.random() * 50_000);
        }
        return data;
    }
    
    private static Integer[] generateStarTemperatures() {
        Integer[] data = new Integer[STAR_TEMPERATURES_SIZE];
        for (int i = 0; i < STAR_TEMPERATURES_SIZE; i++) {
            data[i] = STAR_TEMPERATURES_SIZE - i;
        }
        return data;
    }
    
    private static Integer[] generateGalaxyDistances() {
        Integer[] data = new Integer[GALAXY_DISTANCES_SIZE];
        for (int i = 0; i < GALAXY_DISTANCES_SIZE; i++) {
            data[i] = (int) (Math.random() * 1000);
        }
        return data;
    }
}
