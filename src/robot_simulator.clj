(ns robot-simulator)

(defn robot
  "Given a coordinates and a robot bearing, returns a robot with
  that information."
  [coordinates bearing]
  {:coordinates coordinates
   :bearing     bearing})

(defn move-forward
  [robot-coordinates robot-direction]
  (case robot-direction
    :north (update robot-coordinates :y inc)
    :east (update robot-coordinates :x inc)
    :south (update robot-coordinates :y dec)
    :west (update robot-coordinates :x dec)))

(defn turn-right
  "Given a robot-direction returns the new direction after turn-right"
  [robot-direction]
  (case robot-direction
    :north :east
    :east :south
    :south :west
    :west :north))

(defn turn-left
  "Given a robot-direction returns the new direction after turn-left"
  [robot-direction]
  (case robot-direction
    :north :west
    :west :south
    :south :east
    :east :north))

(defn process-command
  "Given a robot and a command, returns the robot updated with the command executed"
  [robot command]
  (let [robot-direction (:bearing robot)]
    (case command
      \A (update robot :coordinates move-forward robot-direction)
      \R (update robot :bearing turn-right)
      \L (update robot :bearing turn-left))))

(defn simulate
  "Given a robot and a string of commands, simulates the commands returning the new robot"
  [commands robot]
  (let [list-of-commands (seq commands)]
    (loop [robot-state robot
           rest-of-commands list-of-commands]
      (if (empty? rest-of-commands)
        robot-state
        (recur (process-command robot-state (first rest-of-commands)) (rest rest-of-commands))))))
