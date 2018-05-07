(ns clojurice.router
  (:require [reagent.core :as r]
            [bide.core :as b]
            [clojurice.index :as index]))

(def routes
  {:clojurice.home "/home"
   :clojurice.about "/about"})   
            
(def router
  (b/router (->> routes
                 (map (fn [[x y]] [y x]))
                 (into []))))

(defn app-link [target text]
  [:a {:href (target routes)
       :on-click (fn [e]
                   (.preventDefault e)
                   (b/navigate! router target))}
   text])
