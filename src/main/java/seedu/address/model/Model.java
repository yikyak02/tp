package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.order.CustomerOrder;
import seedu.address.model.order.CustomerOrderList;
import seedu.address.model.order.SupplierOrderList;
import seedu.address.model.order.SupplyOrder;
import seedu.address.model.person.Person;
import seedu.address.model.product.*;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    void addPastry(Pastry expectedPastry);

    PastryCatalogue getPastryCatalogue();

    void addIngredient(Ingredient expectedIngredient);

    IngredientCatalogue getIngredientCatalogue();

    void addCustomerOrder(CustomerOrder customerOrder);

    void addSupplyOrder(SupplyOrder supplyOrder);


    ObservableList<SupplyOrder> getSupplyOrderObservableList();

    ObservableList<CustomerOrder> getCustomerOrderObservableList();

    CustomerOrderList getCustomerOrderList();

    SupplierOrderList getSupplierOrderList();

    Inventory getInventory();
}
