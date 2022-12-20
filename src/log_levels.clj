(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (str/trim
    (subs s
          (inc (str/index-of s ":"))
          (count s))))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (str/lower-case (re-find #"ERROR|WARNING|INFO" s)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [log-message (message s)
        level-of-log (log-level s)]
    (str log-message " (" level-of-log ")")))
