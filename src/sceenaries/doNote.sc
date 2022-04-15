theme: /

    state: ВыполнениеЭлементаПоНомеру
        q!: [я] (выполнил|сделал) номер
            @duckling.number:: digit
            $weight<1.001>
        
        script:
            var itemId = findItemIdByNumber(
                $parseTree._digit,
                getRequest($context)
            );
            doNote(itemId, $context);
            
        go!: /ЗаданиеВыполнено


    state: ВыполнениеЭлемента
        q!: [я] (выполнил|сделал)
            $AnyText::anyText
            $weight<-0.8>
            
        script:
            var itemId = findItemIdBySelectedItem(getRequest($context));
            doNote(itemId, $context);
    
        go!: /ЗаданиеВыполнено
        
    state: ЗаданиеВыполнено
        event!: done
        event!: DONE
        
        script:
            addSuggestions(["Добавь задачу купить машину"], $context);
            
        random: 
            a: Молодец!
            a: Красавичк!
            a: Супер!