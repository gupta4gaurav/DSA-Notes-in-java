for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j <= list.size(); j++) {
                if (list.get(i) >= list.get(j)) {
                    return true;
                }
            }
        }