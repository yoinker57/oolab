package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.List;

public class SimulationEngine implements IEngine,Runnable {
    private MoveDirection[] moves = new MoveDirection[]{};
    private final IWorldMap map_animals;
    App renderer;
    int index;
    int delay = 100;
    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map_animals, Vector2d[] positions,App renderer){
        this.renderer = renderer;
        this.moves = directions;
        this.map_animals = map_animals;
        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map_animals, position);
            animal.addObserver(map_animals);
            animal.addObserver(this.map_animals.getBound());
            if (renderer != null){
                animal.addObserver(renderer);
            }
            this.map_animals.place(animal);
        }
        this.map_animals.getBound().sortowanko();
    }
    public SimulationEngine(AbstractWorldMap map_animals, Vector2d[] positions,App renderer){
        this.renderer = renderer;
        this.map_animals = map_animals;
        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map_animals, position);
            animal.addObserver(this.map_animals.getBound());
            animal.addObserver(map_animals);
            if (renderer != null){
                animal.addObserver(renderer);
            }
            this.map_animals.place(animal);
        }
        this.map_animals.getBound().sortowanko();
    }
    @Override
    public void run() {
        if (renderer != null) {
            this.renderer.render();
        }
        List<Animal> animals = this.map_animals.getArray();
        this.index += 1;
        for (int i=0;i<this.moves.length;i++){
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                System.out.println("Error: Przerwano symulacje!");
                throw new RuntimeException(e);
            }
            animals.get(i%animals.size()).move(this.moves[i]);

        }
    }
    public void setDelay(int moveDelay){
        this.delay = moveDelay;
    }
    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }
}
