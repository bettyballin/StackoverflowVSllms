' Read-only property example\npublic class MyClass\n  private bar as string = "example"\n\n  public readonly property foo as string\n    get\n      return bar\n    end get\n  end property\nend class\n\n' Function example\npublic class MyClass\n  private bar as string = "example"\n\n  public function foo() as string\n    return bar\n  end function\nend class