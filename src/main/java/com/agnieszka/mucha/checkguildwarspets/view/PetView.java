package com.agnieszka.mucha.checkguildwarspets.view;

import com.agnieszka.mucha.checkguildwarspets.Pet;
import com.agnieszka.mucha.checkguildwarspets.PetController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("/pet")
public class PetView extends VerticalLayout {
    PetView() {
        H1 title = new H1("Choose your pet");
        DropDownPetMenu form = new DropDownPetMenu();

        TextArea textArea = new TextArea();
        textArea.setMinWidth("500px");
        textArea.setLabel("Description");

        Image petIcon = new Image();

        H2 petName = new H2();

        Button button = createButton(form);
        button.addClickListener(clickEvent -> {
            String id = form.getValue();
            Pet pet = PetController.getPet(id);
            textArea.setValue(pet.description());
            petIcon.setSrc(pet.icon());
            petName.setText(pet.name());
        });

        add(title);
        add(form);
        add(button);
        add(petName);

        HorizontalLayout petCard = new HorizontalLayout();
        petCard.add(petIcon);
        petCard.add(textArea);

        add(petCard);
    }

    Button createButton(DropDownPetMenu form){
        Button button = new Button("SET");
        button.addThemeVariants(ButtonVariant.LUMO_ICON);
        return button;
    }


}
