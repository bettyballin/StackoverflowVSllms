pp
template <typename X, typename Y, typename Z>
struct Foo {};

template <typename X>
struct Foo<X, Base<X>, void> {};                   // #1

template <typename X, typename Y>
struct Foo<X, Y, typename whatever<Y>::type> {};   // #2

// Note: The Base and whatever classes are not defined in this code snippet.
// They would need to be defined elsewhere in the codebase.

// Also, the whatever class would need to have a nested type alias named "type".

// Example definitions for Base and whatever:
template <typename X>
struct Base {};

template <typename Y>
struct whatever {
    using type = void; // or some other type
};